package pruebaPractica;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProcesoHijo {
	private static final String rutaResource = "src\\main\\resources\\";

	public static void main(String[] args) {
		String rutaLectura = rutaResource+args[1];
		String dato = args[0];
		String rutaEscritura = rutaResource+ args[0] + ".txt";
		ProcesoHijo ph = new ProcesoHijo();
		try {
			System.out.println(ph.leerFichero(dato, rutaLectura));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ph.CreaFichero(dato, rutaLectura, rutaEscritura);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> leerFichero(String nombreSensor, String ruta) throws FileNotFoundException {
		List<String> sensor = new ArrayList<String>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(ruta);
			in = new Scanner(fichero);
			while (in.hasNext()) {
				String linea = in.nextLine();
				String[] linea_split = linea.split(";");
				if (nombreSensor.equals(linea_split[0])) {
					sensor.add(linea);
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return sensor;
	}

	public void CreaFichero(String nombreSensor, String rutaFichero, String rutaNueva) throws IOException {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaNueva);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado provincia a provincia
			List<String> provincias = leerFichero(nombreSensor, rutaFichero);
			for(String p: provincias) {
				String[] separacion = p.split(";");
				out.printf("%s%n, %s%n, %s%n",
						separacion[0],
						separacion[1],
						separacion[2]
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