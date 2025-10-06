package boletin1;

import java.io.IOException;

public class Lanzador {
	
	private static final String diractorioGenerarClasses = "C:\\Users\\rodlo\\Documents\\GitHub\\segundoDAM\\segundoDAM\\JAVA\\simulacion_examen\\target";
	private static final String rutaFicherosJava = "C:\\Users\\rodlo\\Documents\\GitHub\\segundoDAM\\segundoDAM\\JAVA\\simulacion_examen\\src\\main\\java";
	
	public static void main(String[] args) {
		
		
	}
	
	public void ejecutarProceso() {
		try {
			String[] comando = {"javac","-d", diractorioGenerarClasses, rutaFicherosJava + "boletin1\\Gestiona.java"};
			ProcessBuilder pb = new ProcessBuilder(comando);
			Process p = pb.start();
			pb.inheritIO();
			Process proceso = pb.start();
			int exit = proceso.waitFor();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
			
	/*
	public void ejecutaProcesoJava() {
		String[] comando = {"java", "-cp", "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\simulacion_examen\\target", "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\simulacion_examen\\src\\main\\resources" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		try {
			Process proceso = pb.start();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
}