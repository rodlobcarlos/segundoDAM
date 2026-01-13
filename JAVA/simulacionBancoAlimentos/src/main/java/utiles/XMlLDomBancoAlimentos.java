package utiles;

// --- Imports ---
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

import simulacionBancoAlimentos_model.CentroLogistico;
import simulacionBancoAlimentos_model.Trabajadores;

// --- Clase ---
public class XMlLDomBancoAlimentos {

	// --- Atributos ---
	private static final Logger logger = LogManager.getLogger(XMlLDomBancoAlimentos.class);
	private static final String resource = "src\\main\\resources\\";
	private XMLDomTrabajadores domTrabajadores;

	// --- Constructor sin parámetros --- 
	public XMlLDomBancoAlimentos() {
		super();
		this.domTrabajadores = new XMLDomTrabajadores(); // inicializa objeto
	}

	// --- Método de leer un listado de centros desde el xml ---
	public List<CentroLogistico> leerCentroListDesdeXML(String rutaFichero) throws Exception {
		List<CentroLogistico> centros = new ArrayList<CentroLogistico>();
		// 1. Calcula el dom desde el xml de la ruta
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta CentroLogistico
		NodeList nodosCentro = doc.getElementsByTagName("CentroLogistico");
		// 3. Recorro la lista de los nodos CentroLogistico
		for (int j = 0; j < nodosCentro.getLength(); j++) {
			Node modeloNodo = nodosCentro.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// crea objeto de centro logistico para llenarlo con los elementos del xml
				CentroLogistico c = this.getCentroFromElement((Element) modeloNodo);
				centros.add(c);
			}
		}
		return centros;
	}

	// --- Método para obtener un centro desde un elemento ---
	private CentroLogistico getCentroFromElement(Element elemento) throws Exception {
		CentroLogistico c = new CentroLogistico(); // crea objeto centro logistico
		// obtiene los elementos de los etiquetas del centro logistico
		String id = elemento.getElementsByTagName("ID").item(0).getTextContent();
		String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
		String ciudad = elemento.getElementsByTagName("Ciudad").item(0).getTextContent().trim();
		int comedores = Integer
				.parseInt(elemento.getElementsByTagName("ComedoresAbastecidos").item(0).getTextContent());
		List<Trabajadores> trabajadores = new ArrayList<Trabajadores>(); // crea lista de trabajadores
		// lista de trabajadores para meter dentro los trabajadores cargados del xml 
		List<Trabajadores> list = domTrabajadores.getTrabajadoresDelCentro(elemento); 
		for (Trabajadores t : list) { // recorremos la lista anterior
			trabajadores.add(t); // añadimos cada trabajador a la lista creada vacía
		}
		// cambiamos los valores de nuestros atributos con el valor de cada elemento del xml
		c.setNombre(nombre);
		c.setId(id);
		c.setCiudad(ciudad);
		c.setComedores_abastecidos(comedores);
		c.setListaTrabajadores(trabajadores);
		return c;

	}

	// --- Método para leer un centro desde el xml ---
	public CentroLogistico leerCentroDesdeXML(String rutaFichero) throws Exception {
		Document doc = getDocumentFromXML(rutaFichero);
		// Obtener el elemento raíz (el único <empleado>)
		Element elementoProduct = doc.getDocumentElement();
		// Usar tu método
		return getCentroFromElement(elementoProduct);
	}

	// --- Método que obtiene un documento desde el xml ---
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
}
