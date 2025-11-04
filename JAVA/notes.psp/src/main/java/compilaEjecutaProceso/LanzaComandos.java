package compilaEjecutaProceso;

import java.io.IOException;

public class LanzaComandos {

	private final static String directorioGeneraClasses = "target\\classes";
	private final static String rutFicheroaJava = "src\\main\\java\\hijos\\Hijo.java";

	public static void main(String[] args) {
		LanzaComandos lc = new LanzaComandos();
		lc.lanzaCompilador(rutFicheroaJava, directorioGeneraClasses);
		lc.ejecutaProcesoJava();
	}

	public void lanzaCompilador(String rutaFichero, String rutaGeneraClass) {
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
		String[] comando = { "java", "-cp", directorioGeneraClasses, rutFicheroaJava};
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
