package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlDom {

	private Empleado getEmpleadoFromElement(Element elemento) {
		Empleado e = new Empleado();
		String nombre = elemento.getElementsByTagName("nombreApellido").item(0).getTextContent();
		int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
		String empresa = elemento.getElementsByTagName("empresa").item(0).getTextContent();
		String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
		e.setEdad(edad);
		e.setNombreApellido(nombre);
		e.setIdentificador(id);
		e.setEmpresa(empresa);
		return e;
	}
	
	public Empleado leerEmpleadoDesdeXML(String rutaFichero) throws Exception {
	       Document doc = getDocumentFromXML(rutaFichero);
	       // Obtener el elemento raíz (el único <empleado>)
	       Element elementoEmpleado = doc.getDocumentElement();
	       // Usar tu método
	       return getEmpleadoFromElement(elementoEmpleado);
	   }

	private Document getDocumentFromXML(String rutaFichero) {
		// TODO Auto-generated method stub
		return null;
	}
}
