package boletin3_ejecicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionaFicherosPaises {

	public List<Pais> leePaises(String rutaFichero) throws FileNotFoundException {
		List<Pais> paises = new ArrayList<Pais>();
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaFichero);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { // Lectura palabra a palabra
				for(Pais p: paises) {
					String linea = in.nextLine();
					String[] linea_split = linea.split(",");
					paises.add(p);
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return paises;
	}
}
