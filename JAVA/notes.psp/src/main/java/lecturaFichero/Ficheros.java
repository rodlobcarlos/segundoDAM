package lecturaFichero;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) {
		Ficheros f = new Ficheros();
		try {
			f.lecturaFichero("src\\main\\resources\\hola.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------------------------------------");
		try {
			f.lecturaFicheroLinea("src\\main\\resources\\hola.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void lecturaFichero(String rutaFichero) throws FileNotFoundException {
		Scanner in = null;

		try {
			FileReader fichero = new FileReader(rutaFichero); // Se abre fichero
			in = new Scanner(fichero); // Se crea el flujo
			while (in.hasNext()) { // Lee el fichero por palabra
				System.out.println(in.next());  // Se hace la lectura completa
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
	
	public void lecturaFicheroLinea(String rutaFichero) throws FileNotFoundException {
		Scanner in = null;

		try {
			FileReader fichero = new FileReader(rutaFichero); // Se abre fichero
			in = new Scanner(fichero); // Se crea el flujo
			while (in.hasNext()) { // Lee el fichero por palabra
				System.out.println(in.nextLine());  // Se hace la lectura completa
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}
