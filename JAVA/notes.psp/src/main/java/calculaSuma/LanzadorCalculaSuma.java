package calculaSuma;

import java.io.IOException;

public class LanzadorCalculaSuma {
	private final static String directorioGeneraClasses = "target\\classes";
	private final static String rutFicheroaJava = "src\\main\\java\\calculaSuma\\CalculaSuma.java";

	public static void main(String[] args) {

		LanzadorCalculaSuma lc = new LanzadorCalculaSuma();
		lc.lanzaCompilador();
		lc.ejecutaProcesoJava();
		lc.ejecutaSubProcesoJava();
		
	}

	public void lanzaCompilador() {
		ProcessBuilder pb;
		String[] comando = { "javac", "-d", directorioGeneraClasses, rutFicheroaJava };
		pb = new ProcessBuilder(comando);
		Process proceso;

		try {
			proceso = pb.start();
			int salidaEstado = proceso.waitFor();
			System.out.println(salidaEstado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Método necesario para ejecutar el hijo
	public void ejecutaProcesoJava() {
		String[] comando = { "java", "-cp", directorioGeneraClasses, rutFicheroaJava, "par", "10" }; // args[0] == par, 10
		ProcessBuilder pb;
		Process proceso;

		try {
			pb = new ProcessBuilder(comando);
			pb.redirectErrorStream(true); // Mensajes de salida normal y errores saldrán en el flujo de salida standar.
			pb.inheritIO(); // Hace que el proceso hijo herede los flujos de entrada/salida del proceso Java que lo crea.
			proceso = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Método necesario para ejecutar el hijo
		public void ejecutaSubProcesoJava() {
			String[] comando = { "java", "-cp", directorioGeneraClasses, rutFicheroaJava, "impar", "11" }; // args[0] == impar, 11
			ProcessBuilder pb;
			Process proceso;

			try {
				pb = new ProcessBuilder(comando);
				pb.redirectErrorStream(true); // Mensajes de salida normal y errores saldrán en el flujo de salida standar.
				pb.inheritIO(); // Hace que el proceso hijo herede los flujos de entrada/salida del proceso Java que lo crea.
				proceso = pb.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
