package pyhton;

import java.io.IOException;

public class LanzadorPython {

	public static void main(String[] args) {

		LanzadorPython lp = new LanzadorPython();
		lp.lanzaCompilador("python", "fichero.py");
		lp.ejecutaProcesoJava();
		
	}

	public void lanzaCompilador(String rutaFichero, String rutaGeneraClass) {
		ProcessBuilder pb;
		String[] comando = { "javac", "-d", "python", "fichero.py" };
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
		String[] comando = { "java", "-cp", "python", "fichero.py"};
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
