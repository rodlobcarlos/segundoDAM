package xml;

public class ControladorEmpleado {

	public static void main(String[] args) {

		XmlDom x = new XmlDom();
		try {
			x.leerEmpleadosDesdeXML("empleado.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
