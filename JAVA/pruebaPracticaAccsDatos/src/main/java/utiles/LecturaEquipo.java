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

import modelDAM_ArenaMasters.Equipo;

public class LecturaEquipo {
	
	private static final String rutaResources = "src\\main\\resources\\";
	private static final Logger logger = LogManager.getLogger(LecturaEquipo.class);

	// LECTURA
		public List<Equipo> leerEquipoDesdeXML(String rutaFichero) throws Exception {
			List<Equipo> equipos = new ArrayList<Equipo>();
			// 1. Calcula el dom
			Document doc = getDocumentFromXML(rutaFichero);
			// 2. Obtener todos los nodos con etiqueta empleados
			NodeList nodosEquipos = doc.getElementsByTagName("equipo");
			// 3. Recorro la lista de los nodos empleado
			for (int j = 0; j < nodosEquipos.getLength(); j++) {
				Node modeloNodo = nodosEquipos.item(j);
				if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
					Equipo e = this.getEquipoFromElement((Element) modeloNodo);
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

		private Equipo getEquipoFromElement(Element elemento) {
			Equipo equipo = new Equipo();
			String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent().trim();
			int numJugadores = Integer.parseInt(elemento.getElementsByTagName("numJugadores").item(0).getTextContent().trim());
			String email = elemento.getElementsByTagName("email").item(0).getTextContent().trim();
			String codigo = elemento.getAttribute("codigo").trim(); 														
			equipo.setNombre(nombre);
			equipo.setNumJugadores(numJugadores);
			equipo.setEmailContacto(email);
			equipo.setCodigo(codigo);
			return equipo;
		}
}
