package analizadorTemperatura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AnalizadorTemperatura {

	public int calculaDias(int umbral, String rutaFichero) throws FileNotFoundException {
		int contador = 0;
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(rutaFichero);
			in = new Scanner(fichero);
			while (in.hasNext()) { 
				String linea = in.nextLine();
				int lineaNumero = Integer.parseInt(linea);
				if(lineaNumero >= umbral) {
					contador++;
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return contador;
	}
	
	public void escrituraFichero(String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			out.printf("El número de veces que aparece dicha palabra es: %d %n");
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}
}
