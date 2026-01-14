package liveFest_utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import liveFest_modelo.Grupo;

public class XMLDomGrupo {

	// --- Atributos ---
	private static final Logger logger = LogManager.getLogger(XMLDomConciertos.class);
	private static final String resource = "src\\main\\resources\\";

	// --- Método de leer lista de conciertos desde un xml ---
	public List<Grupo> leerGrupoListaDesdeXML(String rutaFichero) throws Exception {
		List<Grupo> grupos = new ArrayList<Grupo>();
		// 1. Calcula el dom desde el xml de la ruta
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta grupo
		NodeList nodosGrupo = doc.getElementsByTagName("concierto");
		// 3. Recorro la lista de los nodos grupo
		for (int j = 0; j < nodosGrupo.getLength(); j++) {
			Node modeloNodo = nodosGrupo.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// crea objeto grupo que obtiene al grupo
				Grupo g = this.getGrupoFromElement((Element) modeloNodo);
				grupos.add(g); // añade grupo
			}
		}
		return grupos;
	}

	// --- Método de obtener un concierto desde un elemento ---
	private Grupo getGrupoFromElement(Element elemento) {
		Grupo g = new Grupo(); // crea objeto grupo
		// obtenemos las etiquetas de los grupo
		String codigo = elemento.getElementsByTagName("codigo").item(0).getTextContent().trim();
		String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent().trim();
		int numerointegr = Integer
				.parseInt(elemento.getElementsByTagName("numIntegrantes").item(0).getTextContent().trim());
		String email = elemento.getElementsByTagName("email").item(0).getTextContent();
		String escenario = elemento.getElementsByTagName("escenario").item(0).getTextContent();
		// cambiamos los valores de nuestros atributos a los valores del xml con el'set'
		g.setCodigo(codigo);
		g.setNombre(nombre);
		g.setNumIntegrantes(numerointegr);
		g.setEmail(email);
		return g;
	}

	// --- Método para obtener un documento de un xml ---
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

	// --- Método de leer un concierto desde el xml ---
	public Grupo leerGrupoDesdeXML(String rutaFichero) throws Exception {
		Document doc = getDocumentFromXML(rutaFichero);
		// Obtener el elemento raíz (el único <concierto>)
		Element elementoProduct = doc.getDocumentElement();
		// Usar tu método
		return getGrupoFromElement(elementoProduct);
	}
}
