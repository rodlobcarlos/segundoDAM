package simulacroFormula1_suplies;

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

import simulacroFormula1_model.Pilot;
import simulacroFormula1_model.Team;

public class XMLDomTeams {

	private static final Logger logger = LogManager.getLogger(XMLDomTeams.class);
	private static final String resource = "src\\main\\resources\\";
	private XMLDomPiltos domPiltos;

	public XMLDomTeams() {
		super();
		this.domPiltos = new XMLDomPiltos();
	}

	// Lectura
	private Team getTeamFromElement(Element elemento) throws Exception {
		Team t = new Team();
		String id = elemento.getAttribute("identificadorEquipo");
		String name = elemento.getElementsByTagName("nombreEquipo").item(0).getTextContent();
		int points = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent().trim());
		List<Pilot> pilots = new ArrayList<Pilot>();
		List<Pilot> list = domPiltos.leerPilotListDesdeXML("formula1.xml");
		if (list != null) {
			for (Pilot p : list) {
				if (p.getTeamId().equals(id)) {
					pilots.add(p);

				}
			}
		}

		t.setId(id);
		t.setName(name);
		t.setPoints(points);
		t.setPilotsList(pilots);
		return t;
	}

	public Team leerTeamDesdeXML(String rutaFichero) throws Exception {
		Document doc = getDocumentFromXML(rutaFichero);
		// Obtener el elemento raíz (el único <empleado>)
		Element elementoProduct = doc.getDocumentElement();
		// Usar tu método
		return getTeamFromElement(elementoProduct);
	}

	private Document getDocumentFromXML(String nombrefichero) {
		File file = new File(resource + nombrefichero);
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

	public List<Team> leerTeamListDesdeXML(String rutaFichero) throws Exception {
		List<Team> teams = new ArrayList<Team>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta pelicula
		NodeList nodosTeams = doc.getElementsByTagName("equipo");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosTeams.getLength(); j++) {
			Node modeloNodo = nodosTeams.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Team t = this.getTeamFromElement((Element) modeloNodo);
				teams.add(t);
			}
		}
		return teams;
	}

	// Escritura
	public void escribeTeamEnXML(String nombreFichero, Team t) {
		try {
			Document documento = this.construyoObjetoDocumento("equipo");
			// Recupero la raíz del documento
			Element raiz = documento.getDocumentElement();
			agregaTeamADocumento(documento, raiz, t);
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}

	private void agregaTeamADocumento(Document documento, Element padre, Team t) {
		// Para cada uno de los atributos de equipo, creo un elemento hijo

		this.creaElemento("nombreEquipo", t.getName(), padre, documento);

		this.creaElemento("puntos", String.valueOf(t.getPoints()), padre, documento);

		this.creaElemento("pilotos", String.valueOf(t.getPilotsList()), padre, documento);

		// El identificador lo creamos como un atributo de la etiqueta producto
		// Nota: Si el ID es numérico, usa String.valueOf(p.getId())
		padre.setAttribute("identificadorEquipo", t.getId());
	}

	private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(this.resource + nombreFichero));
		transformer.transform(source, resultado);
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

	private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento);
		padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
		elemento.appendChild(texto);// Cargo el elemento con el valor
		return elemento;
	}

	public void escribeTeamsEnXML(String nombreFichero, List<Team> t) {
		try {
			// Creamos el documento con una RAÍZ en plural (ej: Productos)
			// Esto será <Productos> ... </Productos>
			Document documento = this.construyoObjetoDocumento("equipos");
			Element raiz = documento.getDocumentElement();
			for (Team team : t) {
				// Creamos la etiqueta contenedora para ESTE producto
				Element elementoEquipo = documento.createElement("equipo");

				// Rellenamos el producto con sus datos
				agregaTeamADocumento(documento, elementoEquipo, team);
				raiz.appendChild(elementoEquipo);
			}

			// Escribimos el fichero una sola vez al final
			escribeDocumentoEnFichero(documento, nombreFichero);

		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (TransformerException e1) {
			e1.printStackTrace();
		}
	}
}
