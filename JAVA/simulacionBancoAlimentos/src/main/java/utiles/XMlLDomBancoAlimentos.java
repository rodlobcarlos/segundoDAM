package utiles;

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

public class XMlLDomBancoAlimentos {

	private static final Logger logger = LogManager.getLogger(XMlLDomBancoAlimentos.class);
	private static final String resource = "src\\main\\resources\\";
	private XMLDomTrabajadores domTrabajadores;
	
	

	public XMlLDomBancoAlimentos() {
		super();
		this.domTrabajadores = new XMLDomTrabajadores();
	}

	private CentroLogistico getCentroFromElement(Element elemento) throws Exception {
		CentroLogistico c = new CentroLogistico();
		String id = elemento.getElementsByTagName("ID").item(0).getTextContent();
		String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
		String ciudad = elemento.getElementsByTagName("Ciudad").item(0).getTextContent().trim();
		int comedores = Integer
				.parseInt(elemento.getElementsByTagName("ComedoresAbastecidos").item(0).getTextContent());
		List<Trabajadores> trabajadores = new ArrayList<Trabajadores>();
		List<Trabajadores> list = domTrabajadores.getTrabajadoresDelCentro(elemento);
		for (Trabajadores t : list) {
			trabajadores.add(t);
		}
		c.setNombre(nombre);
		c.setId(id);
		c.setCiudad(ciudad);
		c.setComedores_abastecidos(comedores);
		c.setListaTrabajadores(trabajadores);
		return c;

	}

	public CentroLogistico leerTeamDesdeXML(String rutaFichero) throws Exception {
		Document doc = getDocumentFromXML(rutaFichero);
		// Obtener el elemento raíz (el único <empleado>)
		Element elementoProduct = doc.getDocumentElement();
		// Usar tu método
		return getCentroFromElement(elementoProduct);
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

	public List<CentroLogistico> leerCentroListDesdeXML(String rutaFichero) throws Exception {
		List<CentroLogistico> centros = new ArrayList<CentroLogistico>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta pelicula
		NodeList nodosCentro = doc.getElementsByTagName("CentroLogistico");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosCentro.getLength(); j++) {
			Node modeloNodo = nodosCentro.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				CentroLogistico c = this.getCentroFromElement((Element) modeloNodo);
				centros.add(c);
			}
		}
		return centros;
	}

}
