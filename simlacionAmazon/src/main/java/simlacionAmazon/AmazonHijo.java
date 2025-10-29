package simlacionAmazon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmazonHijo {
	
	public static void main(String[] args) {
		String rutaLectura = args[0] + "provincias.txt";
		String prov = args[1];
		String rutaEscritura = args[0] + args[1] + ".txt";
		AmazonHijo a = new AmazonHijo();
		try {
			a.leerFicheroAmazon(prov, rutaLectura);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a.CreaFicheroProvincia(prov, rutaLectura, rutaEscritura);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> leerFicheroAmazon(String provincia, String ruta) throws FileNotFoundException {
		List<String> prov = new ArrayList<String>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) {
				String linea = in.nextLine();
				String[] linea_split = linea.split("#");
				if (provincia.equalsIgnoreCase(linea_split[5].trim())) {
					prov.add(linea);
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return prov;
	}

	public void CreaFicheroProvincia(String provincia, String rutaFichero, String rutaNueva) throws IOException {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaNueva);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado provincia a provincia
			List<String> provincias = leerFicheroAmazon(provincia, rutaFichero);
			for(String p: provincias) {
				String[] separacion = p.split("#");
				out.printf("Artículo %s %n,	#NumUnidades %s %n,	#Importe %s %n,	#NumReferencia %s %n, #Dirección %s %n,	#Provincia %s %n, #FechaPedido %s %n,", 
						separacion[0],
						separacion[1],
						separacion[2],
						separacion[3],
						separacion[4],
						separacion[5],
						separacion[6]
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
