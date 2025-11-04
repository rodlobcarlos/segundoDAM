package tema1;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeerFichero {

	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);

	public static void main(String[] args) {

		LeerFichero l = new LeerFichero();
		try {
			l.muestraContenidoFich("C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\java\\tema1\\hola.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
	}

	void muestraContenidoFich(String rutaYNombre) throws FileNotFoundException {
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { // Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
				String palabra = in.next();
				logger.info("Palabra: " + palabra);	
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}
