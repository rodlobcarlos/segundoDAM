package xml;

public class ControladorEmpleado {

	public static void main(String[] args) {

		XmlDom x = new XmlDom();
		try {
			x.leerEmpleadoDesdeXML(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
