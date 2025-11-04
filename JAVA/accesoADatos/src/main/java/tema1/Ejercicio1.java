package tema1;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ficheroException.FicherosException;

public class Ejercicio1 {

	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);

	public static void main(String[] args) throws IOException {

		Ejercicio1 f = new Ejercicio1();
		try {
			f.ejercicio1("C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\java");
		} catch (FicherosException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}

	public boolean ejercicio1(String ruta) throws FicherosException {
		String rutaDirectorio = "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\java";
		File directorio = new File(rutaDirectorio);
		File[] archivos = directorio.listFiles();
		boolean existeRuta = false;
		for (File arch : archivos) {
			if (rutaDirectorio.equals(ruta) ) {
				existeRuta = true;
				logger.info(arch.getName());
				logger.info("Es un directorio " + arch.isDirectory());
				logger.info("Es un fichero " + arch.isFile());
			} else {
				throw new FicherosException("Esta ruta no existe.");
			}
		}
		return existeRuta;
	}
}