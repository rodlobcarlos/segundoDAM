package ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Lectura {

	public static void main(String[] args) {
		Lectura l = new Lectura();
		try {
			l.muestraContenidoFich("src\\main\\resources\\lectura.txt");
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
				System.out.println(in.next()); // Aquí se hará la lectura por palabra
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}
