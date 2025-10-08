package tema1;

import java.io.File;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ficheros {

	private static final Logger logger =  LogManager.getLogger(Ficheros.class);
	
	public static void main(String[] args) throws IOException {

		/*
		String rutaDirectorio = "C:\\Users\\alumno\\Desktop";
		File directorio = new File(rutaDirectorio);
		// Referencio a un fichero dentro del directorio soraya
		File fichero = new File(directorio, "fichero.txt");
		try {
			boolean creado = fichero.createNewFile(); // Aquí Sí creo fichero
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Error al crear fichero:" + e.getMessage());
		}
	}

*/
		// 1
		String rutaDirectorio = "C:\\Users\\alumno\\Desktop";
		File directorio = new File(rutaDirectorio);
		// Referencio a un fichero dentro del directorio soraya
		File fichero = new File(directorio, "directorio");
		boolean creado = fichero.mkdir(); // Aquí Sí crea directorio
		String[] archivos = directorio.list();
		for(String ficheros : archivos) {
			if(ficheros.contains(ficheros)) {
				logger.info(ficheros);
			}else {
				logger.error("La ruta no existe.");
			}
		}
		
		
	}
}
