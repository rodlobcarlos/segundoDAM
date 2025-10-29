package simlacionAmazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmazonPadre {

	private static final String rutaResource = "src\\main\\resources\\";
	private static final String diractorioGenerarClasses = "target\\classes";
	private static final String rutaFicherosJava = "src\\main\\java\\simlacionAmazon\\AmazonHijo.java";
	
	public static void main(String[] args) {
		AmazonPadre a = new AmazonPadre();
		a.compilaClaseJava();
		String[] provincias = {"Sevilla", "Huelva", "Cádiz", "Málaga", "Jaén", "Córdoba", "Almería", "Granada"};
		for(String p: provincias) {
			a.ejecutaProcesoJava(p);
		}
	}
	public void compilaClaseJava() {
		try {
			String[] comando = { "javac", "-d", diractorioGenerarClasses,
					rutaFicherosJava};
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
				rutaFicherosJava, rutaResource, provincia};
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
