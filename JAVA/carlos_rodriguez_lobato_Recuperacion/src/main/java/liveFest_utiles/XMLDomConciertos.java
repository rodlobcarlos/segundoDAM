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

import liveFest_modelo.Concierto;
import liveFest_modelo.Escenario;
import liveFest_modelo.Grupo;

// --- Clase ---
public class XMLDomConciertos {

	// --- Atributos ---
	private static final Logger logger = LogManager.getLogger(XMLDomConciertos.class);
	private static final String resource = "src\\main\\resources\\";
	private XMLDomGrupo domGrupo;
	
	public XMLDomConciertos() {
		super();
		this.domGrupo = new XMLDomGrupo();
	}

	// --- Método de leer lista de conciertos desde un xml ---
	public List<Concierto> leerConciertoListaDesdeXML(String rutaFichero) throws Exception {
		List<Concierto> conciertos = new ArrayList<Concierto>();
		// 1. Calcula el dom desde el xml de la ruta
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta concierto
		NodeList nodosConcierto = doc.getElementsByTagName("concierto");
		// 3. Recorro la lista de los nodos concierto
		for (int j = 0; j < nodosConcierto.getLength(); j++) {
			Node modeloNodo = nodosConcierto.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// crea objeto concierto que obtiene al concierto
				Concierto t = this.getConciertoFromElement((Element) modeloNodo);
				conciertos.add(t); // añade concierto
			}
		}
		return conciertos;
	}

	// --- Método de obtener un concierto desde un elemento ---
	private Concierto getConciertoFromElement(Element elemento) {
		Concierto c = new Concierto(); // crea objeto concierto
		// obtenemos las etiquetas de los conciertos
		int id = Integer.parseInt(elemento.getElementsByTagName("id").item(0).getTextContent().trim());
		String fecha = elemento.getElementsByTagName("fecha").item(0).getTextContent().trim();
		String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent().trim();
		Escenario tipo = Enum.valueOf(Escenario.class,
				elemento.getElementsByTagName("escenario").item(0).getTextContent().trim().toUpperCase());
		/**
		String grupo = elemento.getElementsByTagName("grupo").item(0).getTextContent();
		Grupo concierto = null;
		try {
			concierto = (Grupo) domGrupo.leerGrupoDesdeXML(resource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
		// cambiamos los valores de nuestros atributos a los valores del xml con el 'set'
		c.setId(id);
		c.setFecha(fecha);
		c.setDescripcion(descripcion);
		c.setEscenario(tipo);
//		c.setGrupo(concierto);
		return c;
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
	public Concierto leerConciertoDesdeXML(String rutaFichero) throws Exception {
		Document doc = getDocumentFromXML(rutaFichero);
		// Obtener el elemento raíz (el único <concierto>)
		Element elementoProduct = doc.getDocumentElement();
		// Usar tu método
		return getConciertoFromElement(elementoProduct);
	}
}
