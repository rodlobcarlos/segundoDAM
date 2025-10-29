package simulacionAmazon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Procesohijo {
	
	public static void main(String[] args) {
		Procesohijo n = new Procesohijo();
		String ruta = args[0] + "provincias.txt";
		String prov = args[1];
		String rutaFuchero = args[0] + args[1] + ".txt";
		
		try {
			n.leeFicheroProvincia(prov, ruta);
			n.escrituraFichero(prov, ruta,rutaFuchero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> leeFicheroProvincia(String provincia, String rutaFichero) throws FileNotFoundException {
		int contador = 0;
		List<String> p = new ArrayList<String>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(rutaFichero);
			in = new Scanner(fichero);
			while (in.hasNext()) { 
				String linea = in.nextLine();
				String[] provincias = linea.split("#");
				String provinciasSinEspacios = provincias[5].trim();
				if(provinciasSinEspacios.equals(provincia)) {
					p.add(linea);
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return p;
	}
	
	public void escrituraFichero(String provincia ,String rutaFichero,String rutaDestino) throws IOException {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaDestino);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado provincia a provincia
			List<String> pr = leeFicheroProvincia(provincia, rutaFichero);
			for(String l: pr) {
				String[] provincias = l.split("#");
			
			out.printf("Artículo: %s, #NumUnidades: %s, #Importe: %s, #NumReferencia: %s, #Dirección: %s, #Provincia: %s, #FechaPedido: %s %n", 
					provincias[0],
					provincias[1],
					provincias[2],
					provincias[3],
					provincias[4],
					provincias[5],
					provincias[6]
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
