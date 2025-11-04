package amazon;

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
		
		String lectura = args[0] + "provincia.txt";
		String provincia = args[1];
		String 	escritura = args[0] + args[1] + ".txt";
		AmazonHijo ah = new AmazonHijo();
		try {
			ah.lecturaFichero(provincia, escritura);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ah.escriturafichero(provincia, lectura, escritura);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<String> lecturaFichero(String provincia, String rutaFichero) throws FileNotFoundException {
		Scanner in = null;
		List<String> provincias = new ArrayList<String>();

		try {
			FileReader fichero = new FileReader(rutaFichero); // Se abre fichero
			in = new Scanner(fichero); // Se crea el flujo
			in.nextLine();
			while (in.hasNext()) { // Lee el fichero por palabra
				String linea = in.nextLine();  // Se hace la lectura completa
				String[] linea_split = linea.split("#");
				for(String p: provincias) {
					if(provincia.equalsIgnoreCase(linea_split[5].trim())) {
						provincias.add(linea);
					}
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return provincias;
	}
	
	public void escriturafichero(String provincia, String rutaFichero, String nuevoFichero) throws IOException{
		PrintWriter out = null;
		
		try {
			FileWriter fichero;
			fichero = new FileWriter(nuevoFichero); // abre el fichero de texto
			out = new PrintWriter(fichero);// escribe el listado 
			List<String> llamada = lecturaFichero(provincia, rutaFichero); // llamo al método de leer que ya almacena los datos
			for(String p: llamada) {
				String[] linea = p.split("#");
				out.printf("Artículo %s%n, #NumUnidades %d%n, #Importe %d%n, #NumReferencia %d%n, #Dirección %s%n, #Provincia %s%n, #FechaPedido %d%n",
						linea[0],
						linea[1],
						linea[2],
						linea[3],
						linea[4],
						linea[5],
						linea[6]
						);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(out != null) {
				out.close();
			}
		}
	}
}
