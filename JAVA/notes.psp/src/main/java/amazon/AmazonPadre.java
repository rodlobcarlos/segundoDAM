package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmazonPadre {
	
	private final static String rutaResource = "src\\main\\resources";
	private final static String diractorioGenerarClasses = "target\\classes";
	private final static String rutaFicheroJava = "src\\main\\java\\amazon\\AmazonHijo.java";
	
	public static void main(String[] args) {
		
		AmazonPadre ap = new AmazonPadre();
		ap.compilaClaseJava();
		String[] provincias = {"Sevilla", "Huelva", "Málaga", "Jaen", "Cádiz", "Almeria", "Córdoba", "Granada"};
		for(String p: provincias) {
			ap.ejecutaProcesoJava(p);
		}
	}
	
	public void compilaClaseJava() {
		try {
			String[] comando = { "javac", "-d", diractorioGenerarClasses, rutaFicheroJava};
			ProcessBuilder pb = new ProcessBuilder(comando);
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

	public void ejecutaProcesoJava(String provincia) {
		String[] comando = { "java", "-cp", diractorioGenerarClasses,
				rutaFicheroJava, rutaResource, provincia};
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
//			pb.inheritIO();
			Process proceso = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String linea = reader.readLine();
			while(linea != null) {
				System.out.println("Padre: "+ linea);
				linea = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
