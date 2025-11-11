package utilesBancoAlimento;

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

import modelBancoAlimento.CentroLogistico;
import modelBancoAlimento.TipoPersonal;
import modelBancoAlimento.Trabajadores;
import repositoryBancoAlimentacion.RepositoryCentroLogistico;

public class LecturaCentroLogistico {
	private static final Logger logger = LogManager.getLogger(RepositoryCentroLogistico.class);
	private static final String rutaResources = "src\\main\\resources\\";
	
	// LECTURA CENTRO LOGÍSTICO
	public List<CentroLogistico> leerCentroLogisticoDesdeXML(String rutaFichero) throws Exception {
		List<CentroLogistico> centro = new ArrayList<CentroLogistico>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosEquipos = doc.getElementsByTagName("CentroLogistico");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosEquipos.getLength(); j++) {
			Node modeloNodo = nodosEquipos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				CentroLogistico e = this.getCentroLogisticoFromElement((Element) modeloNodo);
				centro.add(e);
			}
		}
		return centro;
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

	private CentroLogistico getCentroLogisticoFromElement(Element elemento) {
		CentroLogistico centro = new CentroLogistico();
		String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
		String id = elemento.getElementsByTagName("ID").item(0).getTextContent().trim();
		String ciudad = elemento.getElementsByTagName("Ciudad").item(0).getTextContent().trim();
		int abastecidos = Integer.parseInt(elemento.getElementsByTagName("ComedoresAbastecidos").item(0).getTextContent().trim());
		centro.setNombre(nombre);
		centro.setIdCentrologistico(id);
		centro.setCuidad(ciudad);
	    List<Trabajadores> trabajadores =addTrabajadoresToCL(elemento, id);
	    centro.setListaTrabajadores(trabajadores);
		centro.setNumeroComedores(abastecidos);
		return centro;
	}
	
	private List<Trabajadores> addTrabajadoresToCL (Element elemento, String id){
	    List<Trabajadores> trabajadores = new ArrayList<>();
	    NodeList listaTrabajadores = elemento.getElementsByTagName("Trabajador");
	    for (int i = 0; i < listaTrabajadores.getLength(); i++) {
	        Element t = (Element) listaTrabajadores.item(i);
	        Trabajadores trabajador = new Trabajadores();
	        trabajador.setNombre(t.getElementsByTagName("Nombre").item(0).getTextContent().trim());
	        trabajador.setDni(t.getElementsByTagName("DNI").item(0).getTextContent().trim());
	        trabajador.setFechaNacimiento(t.getElementsByTagName("FechaNacimiento").item(0).getTextContent().trim());
	        TipoPersonal tipoPersonal = Enum.valueOf(TipoPersonal.class, 
	        		elemento.getElementsByTagName("Tipo").item(0).getTextContent().trim().toUpperCase());	  
	        trabajador.setTipo(tipoPersonal);
	        trabajador.setIdCentroLogistico(id);
	        trabajadores.add(trabajador);
	    }
	    return trabajadores;
	}
}
