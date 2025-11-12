package utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import enumDAM_ArenaMasters.TipoJuego;
import modelDAM_ArenaMasters.Enfrentamiento;
import modelDAM_ArenaMasters.Equipo;

public class LecturaEnfrentamientos {

	private static final String rutaResources = "src\\main\\resources\\";
	private static final Logger logger = LogManager.getLogger(LecturaEnfrentamientos.class);

	// LECTURA
		public List<Enfrentamiento> leerEnfrentamientoDesdeXML(String rutaFichero) throws Exception {
			List<Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
			// 1. Calcula el dom
			Document doc = getDocumentFromXML(rutaFichero);
			// 2. Obtener todos los nodos con etiqueta empleados
			NodeList nodosEnfrentamiento = doc.getElementsByTagName("enfrentamiento");
			// 3. Recorro la lista de los nodos empleado
			for (int j = 0; j < nodosEnfrentamiento.getLength(); j++) {
				Node modeloNodo = nodosEnfrentamiento.item(j);
				if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
					Enfrentamiento e = this.getEnfrentamientoFromElement((Element) modeloNodo);
					enfrentamientos.add(e);
				}
			}
			return enfrentamientos;
		}

		private Document getDocumentFromXML(String nombrefichero) {
			File file = new File(rutaResources + nombrefichero);
			Document documento = null;
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				documento = dBuilder.parse(file);

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return documento;
		}

		private Enfrentamiento getEnfrentamientoFromElement(Element elemento) {
			Enfrentamiento enfrentamiento = new Enfrentamiento();
			String fecha = elemento.getElementsByTagName("fecha").item(0).getTextContent().trim();
			String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent().trim();
			TipoJuego juego = TipoJuego.valueOf(TipoJuego.class, 
					elemento.getElementsByTagName("videojuego").item(0).getTextContent().trim());
			String ganador = elemento.getElementsByTagName("ganador").item(0).getTextContent().trim();
			int id = Integer.parseInt(elemento .getAttribute("id").trim());														
			enfrentamiento.setFechaEnfrentamiento(fecha);
			enfrentamiento.setDescripcion(descripcion);
			enfrentamiento.setVideojuego(juego);
			enfrentamiento.setId(id);
			enfrentamiento.setEquipoGanador(ganador);
			return enfrentamiento;
		}
		
//		// ESCRITURA
//		public void escribeEnfrentamientoEnXML(String nombreFichero, Enfrentamiento enfrentamiento) {
//			try {
//				Document documento = this.construyoObjetoDocumento("formula1.xml");
//				Element raiz = documento.getDocumentElement();
//				agregaEnfrentamientoADocumento(documento, raiz, enfrentamiento);
//				escribeDocumentoEnFichero(documento, nombreFichero);
//			} catch (ParserConfigurationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (TransformerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
//			Element elemento = documento.createElement(nombreElemento);
//			Text texto = documento.createTextNode(valorElemento);
//			padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
//			elemento.appendChild(texto);// Cargo el elemento con el valor
//			return elemento;
//		}
//
//		private Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
//			Document documento = null;
//			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factoria.newDocumentBuilder();
//			DOMImplementation implementacion = builder.getDOMImplementation();
//			documento = implementacion.createDocument(null, nombreRaiz, null);
//			// Primer parámetro uri: si null no está validado por ninguna ruta
//			// segundo parámetro: nombre fichero
//			// tercer parámetro: document type Por defecto null
//			return documento;
//		}
//
//		private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
//			// clases necesarias finalizar la creación del archivo XML
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			Transformer transformer;
//			transformer = transformerFactory.newTransformer();
//			DOMSource source = new DOMSource(documento);
//			StreamResult resultado = new StreamResult(new File(this.rutaResources + nombreFichero));
//			transformer.transform(source, resultado);
//		}
//
//		private void agregaEnfrentamientoADocumento(Document documento, Element padre, Enfrentamiento enfrentamiento, List<Equipo> equipos) {
//			Element ganador = this.creaElemento("equipoGanador", enfrentamiento.getEquipoGanador(), padre, documento);
//			Element fecha = this.creaElemento("fecha", enfrentamiento.getFechaEnfrentamiento(), padre, documento);
//			Element enfretamiento = documento.createElement("enfrentamientos");
//			Element enfretamientoElement = documento.createElement("enfrentamientos");
//		    for (Equipo e : equipos) {
//		    	if(e.getCodigo().equals(enfrentamiento.getEquipoGanador())) {
//		    		Element equipoElement = documento.createElement("equipo");
//			        Element ganadorEquipo = this.creaElemento("ganador", e.getCodigo(), equipoElement, documento);
//			        padre.appendChild(equipoElement);
//					padre.setAttribute("id", Integer.parseInt(enfrentamiento.getId()));
//		    	}
//		    	 	
//		    }
//		   
//		}
//
//		public void escribeEquipoXML(List<Enfrentamiento> enfrentamientos, String rutaFichero) {
//			try {
//				Document documento = this.construyoObjetoDocumento("enfrentamiento");
//				for (Enfrentamiento e : enfrentamientos) {
//					Element elemento = this.creaElemento("equipo", null, documento.getDocumentElement(), documento);
//					agregaEnfrentamientoADocumento(documento, elemento, e);
//				}
//				escribeDocumentoEnFichero(documento, rutaFichero);
//			} catch (ParserConfigurationException e1) {
//				logger.error(e1.getMessage());
//			} catch (TransformerException e1) {
//				logger.error(e1.getMessage());
//			}
//		}
}
