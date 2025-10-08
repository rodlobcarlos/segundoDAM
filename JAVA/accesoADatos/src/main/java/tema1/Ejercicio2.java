package tema1;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ficheroException.FicherosException;

public class Ejercicio2 {
	
	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);

	public static void main(String[] args) {

		Ejercicio2 e = new Ejercicio2();
		try {
			e.ejercicio2("C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\java");
		} catch (FicherosException e1) {
			// TODO Auto-generated catch block
			logger.info("Esta ruta no existe.");
		}
		
	}

	public boolean ejercicio2(String ruta) throws FicherosException {
		String rutaDirectorio = "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\java";
		File directorio = new File(rutaDirectorio);
		File[] archivos = directorio.listFiles();
		boolean existeRuta = false;
		for (File arch : archivos) {
			if (rutaDirectorio.equals(ruta) ) {
				existeRuta = true;
				logger.info("Nombre del archivo " + arch.getName());
				logger.info("Se puede leer " + arch.canRead());
				logger.info("Se puede escribir " + arch.canWrite());
				logger.info("Tamaño " + arch.length());
				logger.info("Es un directorio " + arch.isDirectory());
				logger.info("Es un fichero " + arch.isFile());

			}else {
				throw new FicherosException("Esta ruta no existe.");
			}
		}
		return existeRuta;		
	}
}
