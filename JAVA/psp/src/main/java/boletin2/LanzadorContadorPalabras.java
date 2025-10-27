package boletin2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzadorContadorPalabras {
	
	private static final String diractorioGenerarClasses = "target\\ejempli";
	private static final String rutaFicherosJava = "src\\main\\java\\ejempli\\ClaseHija.java";

	public static void main(String[] args) {

		
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
	
	public void ejecutaProcesoJava() {
		String[] comando = { "java", "-cp", diractorioGenerarClasses,
				rutaFicherosJava};
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
