package boletin1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ContadorPalabras2 {
	
	private final static String rutaResources = "src\\main\\resources\\";
	
	public static void main(String[] args) throws FileNotFoundException {
		String ruta = rutaResources + args[0];
		String palabra = args[1];
		ContadorPalabras2 c = new ContadorPalabras2();
		c.cuentaPalabras(palabra, ruta);
	}

	public int cuentaPalabras(String palabra, String rutaFichero) throws FileNotFoundException {
		int contador = 0;
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(rutaFichero);
			in = new Scanner(fichero);
			while (in.hasNext()) {
				String linea = in.nextLine();
				String[] palabras = linea.split(" ");
				for (String p : palabras) {
					String palabraEs = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
					if (p.equalsIgnoreCase(palabra))
						;
					contador += 1;
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return contador;
	}

//	public void escribeNumero(int numero, File rutaFichero) {
//		PrintWriter out = null;
//		try {
//			FileWriter ficheroSalida;
//			ficheroSalida = new FileWriter(rutaFichero);
//			out = new PrintWriter(ficheroSalida);
//			out.printf("El número de veces que aparece dicha palabra es: %d %n", numero);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if(out != null) {
//				out.close();
//			}
//		}
//	}
}
