package utiles;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class ManejaJson {

	public static void main(String[] args) {

		try {
			  Gson gson = new Gson();
			  String rutaFichero = null;
			  FileReader fichero = new FileReader(rutaFichero);
			  // Leer el archivo JSON y convertirlo a un objeto Empleado
			  Empleado[] empleadosArray = gson.fromJson(fichero,Empleado[].class);
				List<Empleado> empleados = Arrays.asList(empleadosArray);
				System.out.println(empleados);
			} catch (Exception e) {
				System.out.println("Error al leer empleados"+e.getMessage());
			}

	}

}
