package tema1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContadorPalabras {

	private static String rutaFichero = "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\resources\\Fichero.txt";

	private static final Logger logger = LogManager.getLogger(ContadorPalabras.class);

	public int cuentaPalabras(String palabra, String rutaFichero) throws FileNotFoundException {
		File archivo = new File(rutaFichero, "Fichero.txt");
		int contador = 0;
		FileReader fichero = new FileReader(rutaFichero);
		Scanner in = new Scanner(fichero);

		while (in.hasNextLine()) {
			String linea = in.nextLine();
			String[] palabras = linea.split(" ");
			
			for (String p : palabras) {
				if (p.equalsIgnoreCase(palabra));
				contador++;
			}
		}
		return contador;
	}
	
	public void escribeNumero(int numero, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida = new FileWriter(rutaFichero);
			out = new PrintWriter(ficheroSalida);
			out.printf(rutaFichero, numero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
