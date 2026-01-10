package simulacroFormula1_suplies;

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

import simulacroFormula1_model.Pilot;

public class XMLDomPiltos {

	private static final Logger logger = LogManager.getLogger(XMLDomTeams.class);
	private static final String resource = "src\\main\\resources\\";
	
	public List<Pilot> leerPilotListDesdeXML(String rutaFichero) throws Exception {
		List<Pilot> pilotos = new ArrayList<Pilot>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosPiloto = doc.getElementsByTagName("piloto");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosPiloto.getLength(); j++) {
			Node modeloNodo = nodosPiloto.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Pilot e = this.getPilotoFromElement((Element) modeloNodo);
				pilotos.add(e);
			}
		}
		return pilotos;
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

	private Pilot getPilotoFromElement(Element elemento) {
		Pilot p = new Pilot();
		String name = elemento.getElementsByTagName("nombrePiloto").item(0).getTextContent().trim();
		String country = elemento.getElementsByTagName("pais").item(0).getTextContent().trim();
		int points = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent().trim());
		String teamId = elemento.getElementsByTagName("identificadorEquipo").item(0).getTextContent().trim();
		String id = elemento.getAttribute("identificadorPiloto").trim(); 
		p.setName(name);
		p.setCountry(country);
		p.setId(id);
		p.setPoints(points);
		p.setTeamId(teamId);
		return p;
	}
}
