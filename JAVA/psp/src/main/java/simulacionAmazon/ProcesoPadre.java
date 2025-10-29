package simulacionAmazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcesoPadre {

	private static final String rutaResource = "src\\main\\resources\\";
	private static final String diractorioGenerarClasses = "target/classes";
	private static final String rutaFicherosJava = "src/main/java/simulacionAmazon/ProcesoHijo.java";
	
	public static void main(String[] args) {
		String[] provincias = {"Sevilla", "Huelva", "Córdoba", "Jaén", "Almería", "Granada", "Málaga", "Cádiz"};
		ProcesoPadre pp = new ProcesoPadre();
		pp.compilaClaseJava();
		for(String provincia: provincias) {	
			
			pp.ejecutaProcesoJava(provincia);
		}
	}
	
	public void compilaClaseJava() {  
		String[] comando = { "javac", "-d", diractorioGenerarClasses, rutaFicherosJava };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			Process p = pb.start();
			pb.inheritIO();
			Process proceso = pb.start();
			int exit = proceso.waitFor();
			System.out.println(exit);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Process ejecutaProcesoJava(String provincia) {
		Process p1 = null;
		try {
			String[] comando = { "java", "-cp", diractorioGenerarClasses, rutaFicherosJava, rutaResource,
					provincia };
			ProcessBuilder pb = new ProcessBuilder(comando);
//			pb.redirectErrorStream(true);
			pb.inheritIO(); // flujo de errores
			p1 = pb.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

			int exit = p1.waitFor();
			System.out.println(exit);

			if (exit != 0) {
				String errorLinea = errorReader.readLine();
				while (errorLinea != null) {
					System.err.println("Error Padre: " + errorLinea);
					errorLinea = errorReader.readLine();
				}
			} else {
				String linea = reader.readLine();

				while (linea != null) {
					System.out.println("Padre: " + linea);
					linea = reader.readLine();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return p1;
	}

}
