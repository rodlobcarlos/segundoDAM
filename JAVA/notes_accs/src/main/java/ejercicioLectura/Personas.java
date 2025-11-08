package ejercicioLectura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Personas {

	public static void main(String[] args) {

		Personas a = new Personas();
		try {
			a.muestraContenidoFich("src\\main\\resources\\fichero1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void muestraContenidoFich(String rutaYNombre) throws FileNotFoundException {
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { // Lectura palabra a palabra
				String palabra = in.next(); // Aquí se hará la lectura por palabra
				System.out.println("Alumno:" + palabra);
				while(in.hasNext()) {
					String nota = in.next(); // Aquí se hará la lectura por nota
					System.out.println("Nota: " + nota); 
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}
