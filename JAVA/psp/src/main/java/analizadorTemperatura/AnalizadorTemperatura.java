package analizadorTemperatura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AnalizadorTemperatura {
	
	public static void main(String[] args) {
		String ruta = args[0] + "temperatura.txt";
		int temperatura = Integer.parseInt(args[1]);
		String rutaFuchero = args[0] + args[1] + ".txt";
		AnalizadorTemperatura a = new AnalizadorTemperatura();
		try {
			a.calculaDias(temperatura, ruta);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
	
	public void escrituraFichero(int umbral, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			int dias = calculaDias(umbral, rutaFichero);
			out.printf("El número de veces que aparece dicha palabra es: %d %n",
					dias
					);
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}
}
