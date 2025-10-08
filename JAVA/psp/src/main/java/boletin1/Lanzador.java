package boletin1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lanzador {

	private static final String diractorioGenerarClasses = "target\\boletin1";
	private static final String rutaFicherosJava = "src\\main\\java\\boletin1\\Gestiona.java";

	private static final Logger logger = LogManager.getLogger(Lanzador.class);

	public static void main(String[] args) {

		Lanzador l = new Lanzador();
		l.proceso();

	}

	public void proceso() {
		try {
			String[] comando = { "javac", "-d", diractorioGenerarClasses,
					rutaFicherosJava + "Gestiona.java" };
			ProcessBuilder pb = new ProcessBuilder(comando);
			Process p = pb.start();
			pb.inheritIO();
			Process proceso = pb.start();
			int exit = proceso.waitFor();
			logger.info("exit");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	
	public void ejecutaProcesoJava() {
		String[] comando = { "java", "-cp", "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\simulacion_examen\\target",
				"C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\simulacion_examen\\src\\main\\resources" };
		ProcessBuilder pb = new ProcessBuilder(comando);

		try {
			Process proceso = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}