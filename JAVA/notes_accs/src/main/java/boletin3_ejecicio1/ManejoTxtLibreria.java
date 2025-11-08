package boletin3_ejecicio1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class ManejoTxtLibreria {

	public void escrituraFichero(Set<Libro> lista, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (Libro l : lista) {
				out.printf(" AUTOR: nombreAutor %s, apellidos %s, LIBRO: isbn %s, titulo %s, nombre %s, nombreEditorial %s%n",
						l.getNombreAutor(),
						l.getApellidos(),
						l.getIsbn(),
						l.getTitulo(),
						l.getNombre(),
						l.getNombreEditorial()
						);
			}
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}
}
