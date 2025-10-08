package tema1;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio4 {

	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);

	public static void main(String[] args) {
		
		Ejercicio4 e = new Ejercicio4();
		String rutaDirectorio = "C:\\Users\\rodlo\\Desktop";
		File directorio = new File(rutaDirectorio);
		e.ejericicio4(directorio);
		
	}

	public void ejericicio4(File ruta) {
		
		if (ruta.exists() && ruta.isDirectory()) {
			File[] directorios = ruta.listFiles();
			for (File f : directorios) {
				if (f.isDirectory()) {
					ejericicio4(f);
					logger.debug(f.getName());
				} else {
					logger.debug(f.getName());
					logger.debug(f.getAbsolutePath());
				}
			}
		}else {
			logger.debug(ruta.getName());
			logger.debug(ruta.getAbsolutePath());
		}
	}

}
