package utiles;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tema1.Notas;
import tema1.Persona;

public class ManejaFicheroPersona {
	
	private static final Logger logger = LogManager.getLogger(ManejaFicheroPersona.class);


	public void cargarLista(String rutaYNombre) throws FileNotFoundException {
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNextLine()) { // Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
				String linea = in.nextLine();
				Persona p = cargaPersona(linea);
				logger.info(p.toString());
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	public Persona cargaPersona(String linea) {
		String[] cadenas = linea.split(" ");
		List<Notas> lista = new ArrayList<Notas>();
		for (int i = 1; i < cadenas.length; i++) {
			Notas n = new Notas(Double.parseDouble(cadenas[i]));
			lista.add(n);
		}
		Persona p = new Persona(cadenas[0], lista);
		return p;

	}
}
