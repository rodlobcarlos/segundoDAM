package repositoryF1;

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

import modelF1.Piloto;

public class RepositoryPilotos {

	private static final String rutaResources = "src\\main\\resources\\";
	private static final Logger logger = LogManager.getLogger(RepositoryEquiposF1.class);

	private List<Piloto> listaPiloto;

	public List<Piloto> getListaPiloto() {
		return listaPiloto;
	}

	public void setListaPiloto(List<Piloto> listaPiloto) {
		this.listaPiloto = listaPiloto;
	}

	public RepositoryPilotos() {
		super();
		this.listaPiloto = listaPiloto;
	}

	@Override
	public String toString() {
		return "RepositoryPilotos [listaPiloto=" + listaPiloto + "]";
	}
	
	// LECTURA
		public List<Piloto> leerPilotoDesdeXML(String rutaFichero) throws Exception {
			List<Piloto> pilotos = new ArrayList<Piloto>();
			// 1. Calcula el dom
			Document doc = getDocumentFromXML(rutaFichero);
			// 2. Obtener todos los nodos con etiqueta empleados
			NodeList nodosPiloto = doc.getElementsByTagName("piloto");
			// 3. Recorro la lista de los nodos empleado
			for (int j = 0; j < nodosPiloto.getLength(); j++) {
				Node modeloNodo = nodosPiloto.item(j);
				if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
					Piloto e = this.getPilotoFromElement((Element) modeloNodo);
					pilotos.add(e);
				}
			}
			return pilotos;
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

		private Piloto getPilotoFromElement(Element elemento) {
			Piloto piloto = new Piloto();
			String nombre = elemento.getElementsByTagName("nombrePiloto").item(0).getTextContent().trim();
			String pais = elemento.getElementsByTagName("pais").item(0).getTextContent().trim();
			int puntos = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent().trim());
			int idEquipo = Integer.parseInt(elemento.getElementsByTagName("identificadorEquipo").item(0).getTextContent().trim());
			NodeList listaPilotosNodos = null;
			int id = Integer.parseInt(elemento.getAttribute("identificadorPiloto").trim()); 
			piloto.setNombre(nombre);
			piloto.setPais(pais);
			piloto.setPuntos(puntos);
			piloto.setIdentificadorEquipo(idEquipo);
			return piloto;
		}
}
