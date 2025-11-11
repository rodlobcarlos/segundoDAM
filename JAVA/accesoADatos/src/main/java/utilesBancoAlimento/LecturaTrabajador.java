package utilesBancoAlimento;

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

import enu.ServConversaciones.TipoAgente;
import modelBancoAlimento.TipoPersonal;
import modelBancoAlimento.Trabajadores;
import repositoryBancoAlimentacion.RepositoryCentroLogistico;

public class LecturaTrabajador {
	private static final Logger logger = LogManager.getLogger(LecturaTrabajador.class);
	private static final String rutaResources = "src\\main\\resources\\";

	// LECTURA TRABAJADORES
	public List<Trabajadores> leerTrabajadoresDesdeXML(String rutaFichero) throws Exception {
		List<Trabajadores> equipos = new ArrayList<Trabajadores>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosEquipos = doc.getElementsByTagName("Trabajador");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosEquipos.getLength(); j++) {
			Node modeloNodo = nodosEquipos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Trabajadores e = this.getTrabajadoresFromElement((Element) modeloNodo);
				equipos.add(e);
			}
		}
		return equipos;
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

	private Trabajadores getTrabajadoresFromElement(Element elemento) {
		Trabajadores trabajador = new Trabajadores();
		String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
		String dni = elemento.getElementsByTagName("DNI").item(0).getTextContent().trim();
		String fechaNacimiento = elemento.getElementsByTagName("FechaNacimiento").item(0).getTextContent().trim();
		TipoPersonal tipoPersonal = Enum.valueOf(TipoPersonal.class,
				elemento.getElementsByTagName("Tipo").item(0).getTextContent().trim().toUpperCase());
		trabajador.setNombre(nombre);
		trabajador.setDni(dni);
		trabajador.setFechaNacimiento(fechaNacimiento);
		trabajador.setTipo(tipoPersonal);
		return trabajador;
	}
}
