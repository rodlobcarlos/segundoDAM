package boletin3_ejecicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import metodos.CrearFicheros_Directorios;

public class GestionaPaises {

	private static final Logger logger = LogManager.getLogger(CrearFicheros_Directorios.class);

	public static void main(String[] args) {

		GestionaPaises paises = new GestionaPaises();
		try {
			paises.muestraContenidoFich("src\\main\\resources\\paises.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void muestraContenidoFich(String rutaFichero) throws FileNotFoundException {
		List<Pais> paises = new ArrayList<Pais>();
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaFichero);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { // Lectura palabra a palabra
				logger.info(in.nextLine());
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}
