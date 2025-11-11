package repositoryF1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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

import ModelAct2DOM.Producto;
import modelF1.Equipo;
import modelF1.ExceptionF1;
import modelF1.Piloto;

public class RepositoryF1 {
	
	private static final String rutaResources = "src\\main\\resources\\";
	private static final Logger logger = LogManager.getLogger(RepositoryF1.class);

	private List<Equipo> listaEquipos;

	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	@Override
	public String toString() {
		return "RepositoryF1 [listaEquipos=" + listaEquipos + "]";
	}

	public RepositoryF1(List<Equipo> listaEquipos) {
		super();
		this.listaEquipos = listaEquipos;
	}
	
	public void añadirEquipo(Equipo equipo) {
		listaEquipos.add(equipo);
	}
	
	public Equipo leerEquipo(String nombre) throws ExceptionF1 {
		Equipo equipo1 = null;
		boolean encontrado = false;
		Iterator<Equipo> e = listaEquipos.iterator();
		while (!encontrado && e.hasNext()) {
			Equipo equipo2 = e.next();
			if (equipo2.getNombre().equals(nombre)) {
				equipo1 = equipo2;
				encontrado = true;
			} else {
				throw new ExceptionF1("Este piloto ya existe.");
			}
		}
		return equipo1;
	}
	
	public void añadirPiloto(Piloto piloto, Equipo equipo) throws ExceptionF1 {
		List<Piloto> listaPilotos = equipo.getListaPilotos();
		if(listaPilotos.contains(piloto)) {
			throw new ExceptionF1("Este piloto ya existe.");
		}else {
			listaPilotos.add(piloto);
		}
	}
	
	public List<Piloto> leerPiloto(Equipo equipo) throws ExceptionF1 {
		List<Piloto> listaPilotos = equipo.getListaPilotos();
		return listaPilotos;
	}
	
	// ESCRITURA
		public void escribeEquipoEnXML(String nombreFichero, Equipo equipo) {
			try {
				Document documento = this.construyoObjetoDocumento("formula1.xml");
				Element raiz = documento.getDocumentElement();
				agregaEquipoADocumento(documento, raiz, equipo);
				escribeDocumentoEnFichero(documento, nombreFichero);
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
			Element elemento = documento.createElement(nombreElemento);
			Text texto = documento.createTextNode(valorElemento);
			padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
			elemento.appendChild(texto);// Cargo el elemento con el valor
			return elemento;
		}

		private Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
			Document documento = null;
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementacion = builder.getDOMImplementation();
			documento = implementacion.createDocument(null, nombreRaiz, null);
			// Primer parámetro uri: si null no está validado por ninguna ruta
			// segundo parámetro: nombre fichero
			// tercer parámetro: document type Por defecto null
			return documento;
		}

		private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
			// clases necesarias finalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(documento);
			StreamResult resultado = new StreamResult(new File(this.rutaResources + nombreFichero));
			transformer.transform(source, resultado);
		}

		private void agregaEquipoADocumento(Document documento, Element padre, Equipo equipo) {
			Element nombre = this.creaElemento("nombre", equipo.getNombre(), padre, documento);
			Element puntuacion = this.creaElemento("puntuacion", Integer.toString(equipo.getPuntuacion()), padre, documento);
			NodeList<Piloto> pilotos;
			padre.setAttribute("identificador", equipo.getIdentificadorEquipo());
		}

		public void escribeEquipoXML(List<Equipo> equipos, String rutaFichero) {
			try {
				Document documento = this.construyoObjetoDocumento("empleados");
				for (Producto e : productos) {
					Element elemento = this.creaElemento("empleado", null, documento.getDocumentElement(), documento);
					agregaEquipoADocumento(documento, elemento, e);
				}
				escribeDocumentoEnFichero(documento, rutaFichero);
			} catch (ParserConfigurationException e1) {
				logger.error(e1.getMessage());
			} catch (TransformerException e1) {
				logger.error(e1.getMessage());
			}
		}

		//LECTURA
		public List<Producto> leerProductoDesdeXML(String rutaFichero) throws Exception {
			List<Producto> productos = new ArrayList<Producto>();
			// 1. Calcula el dom
			Document doc = getDocumentFromXML(rutaFichero);
			// 2. Obtener todos los nodos con etiqueta empleados
			NodeList nodosProductos = doc.getElementsByTagName("Producto");
			// 3. Recorro la lista de los nodos empleado
			for (int j = 0; j < nodosProductos.getLength(); j++) {
				Node modeloNodo = nodosProductos.item(j);
				if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
					Producto e = this.getProductoFromElement((Element) modeloNodo);
					productos.add(e);
				}
			}
			return productos;
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

		private Equipo getProductoFromElement(Element elemento) {
			Equipo producto = new Producto();
		    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
			double precio = Double.parseDouble(elemento.getElementsByTagName("Precio").item(0).getTextContent().trim());
			int stock = Integer.parseInt(elemento.getElementsByTagName("Stock").item(0).getTextContent().trim());
			int id = Integer.parseInt(elemento.getAttribute("id").trim()); // La etiqueta empleado tiene el atributo identificador
			boolean enVenta = Boolean.parseBoolean(elemento.getAttribute("enVenta"));
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setStock(stock);
			return producto;
		}
}