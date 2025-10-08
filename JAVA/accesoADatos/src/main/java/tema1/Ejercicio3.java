package tema1;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {
	

	public static void main(String[] args) {

		Ejercicio3 e = new Ejercicio3();
		try {
			e.ejercicio3();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void ejercicio3() throws IOException {
		String rutaDirectorio = "C:\\Users\\rodlo\\Desktop\\miDirectorio";
		File directorio = new File(rutaDirectorio);
		boolean creado1 = directorio.mkdir();
		File fichero1 = new File(rutaDirectorio, "fichero1");
		File fichero2 = new File(rutaDirectorio, "fichero2");
		
		String ruta = "C:\\Users\\rodlo\\Desktop\\miDirectorio\\fichero3.txt";
		File fichero3 = new File(rutaDirectorio, "fichero3");
		

		boolean creado2 = fichero1.createNewFile();
		boolean creado3 = fichero2.createNewFile();

		boolean esSoloLeido1 = fichero1.setReadOnly();
		boolean esEscrito1 = fichero1.canWrite();
		boolean esLeido1 = fichero1.canRead();

		boolean permisoEscrito2 = fichero2.canWrite();
		boolean esLeido2 = fichero2.canRead();

		boolean esRenombrado = fichero1.renameTo(fichero3);
	}
}
