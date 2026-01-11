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

import simulacionBancoAlimentos_model.Personal;
import simulacionBancoAlimentos_model.Trabajadores;

public class XMLDomTrabajadores {

	private static final Logger logger = LogManager.getLogger(XMLDomTrabajadores.class);
	private static final String resource = "src\\main\\resources\\";

	public List<Trabajadores> leerTrabajadoresListDesdeXML(String rutaFichero) throws Exception {
		List<Trabajadores> trabajadores = new ArrayList<Trabajadores>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosTrabajador = doc.getElementsByTagName("Trabajador");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosTrabajador.getLength(); j++) {
			Node modeloNodo = nodosTrabajador.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Trabajadores t = this.getTrabajadorFromElement((Element) modeloNodo);
				trabajadores.add(t);
			}
		}
		return trabajadores;
	}
	
	// Metedo para el bucle del csv
	public List<Trabajadores> getTrabajadoresDelCentro(Element elementoCentro) {
        List<Trabajadores> trabajadores = new ArrayList<Trabajadores>();

        // 1. Buscamos la etiqueta contenedora <Trabajadores> DENTRO de este centro
        NodeList nodoContenedor = elementoCentro.getElementsByTagName("Trabajadores");

        if (nodoContenedor.getLength() > 0) {
            Element contenedor = (Element) nodoContenedor.item(0);
            
            // 2. Buscamos solo los nodos <Trabajador> que están DENTRO de esa etiqueta
            NodeList nodosTrabajador = contenedor.getElementsByTagName("Trabajador");

            for (int j = 0; j < nodosTrabajador.getLength(); j++) {
                Node modeloNodo = nodosTrabajador.item(j);
                if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
                    Trabajadores t = this.getTrabajadorFromElement((Element) modeloNodo);
                    trabajadores.add(t);
                }
            }
        }
        return trabajadores;
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

	public Trabajadores leerTeamDesdeXML(String rutaFichero) throws Exception {
		Document doc = getDocumentFromXML(rutaFichero);
		// Obtener el elemento raíz (el único <empleado>)
		Element elementoProduct = doc.getDocumentElement();
		// Usar tu método
		return getTrabajadorFromElement(elementoProduct);
	}

	private Trabajadores getTrabajadorFromElement(Element elemento) {
		Trabajadores t = new Trabajadores();
		String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
		String DNI = elemento.getElementsByTagName("DNI").item(0).getTextContent().trim();
		String FechaNacimiento = elemento.getElementsByTagName("FechaNacimiento").item(0).getTextContent().trim();
		Personal tipo = Enum.valueOf(Personal.class,
				elemento.getElementsByTagName("Tipo").item(0).getTextContent().trim().toUpperCase());
		t.setNombre(nombre);
		t.setDNI(DNI);
		t.setFecha_nacimiento(FechaNacimiento);
		t.setTipo(tipo);
		return t;
	}

}
