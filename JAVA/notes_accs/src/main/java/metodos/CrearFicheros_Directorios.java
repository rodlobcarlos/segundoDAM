package metodos;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrearFicheros_Directorios {

	private static final Logger logger = LogManager.getLogger(CrearFicheros_Directorios.class);

	public static void main(String[] args) {

		CrearFicheros_Directorios c = new CrearFicheros_Directorios();
		c.crearFichero();
		c.listarContenidoFichero();

	}

	public void crearFichero() {
		String rutaDirectorio = "C:\\Users\\rodlo\\OneDrive\\Escritorio";
		File directorio = new File(rutaDirectorio);
		// Referencio a un fichero dentro del directorio
		File fichero = new File(directorio, "fichero.txt");
		try {
			boolean creado = fichero.createNewFile(); // Aquí Sí creo fichero
			// creado = fichero.delete();
			logger.info(creado); // booleano, si se ha creado o no (true/false)
			if (fichero.exists()) { // Si existe
				logger.info("El fichero ya existe");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Error al crear fichero:" + e.getMessage());
		}
	}

	public void listarContenidoFichero() {
		String rutaDirectorio = "C:\\Users\\rodlo\\OneDrive\\Escritorio";
		File directorio = new File(rutaDirectorio);
		// Referencio a un fichero dentro del directorio
		File fichero = new File(directorio, "fichero.txt");
		System.out.println(directorio.exists()); // Si existe
		System.out.println(directorio.isFile()); // Si es fichero
		// Comprobar si el directorio existe y es un directorio
		if (directorio.exists() && directorio.isDirectory()) {
			for (File f : directorio.listFiles())// Listamos el contenido del directorio
			{
				System.out.println(f.getName());
				System.out.println(f.getAbsolutePath());
			}
		} else {
			System.out.println("El directorio no existe o no es un directorio.");
		}

	}

}
