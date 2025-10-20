package boletin1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanzadorCalculaSuma {

	private static final Logger logger = LogManager.getLogger(LanzadorCalculaSuma.class);

	public static void main(String[] args) {

		LanzadorCalculaSuma l = new LanzadorCalculaSuma();
		l.ejecutaProcesoJava();
		l.ejecutaSubprocesoProcesoJava();
	}

	public void proceso() {
		try {
			String[] comando = { "javac", "-d", "src/main/java/boletin1", "CalculaSuma.java" };
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
		String[] comando = { "java", "-cp", "target/classes", "boletin1.CalculaSuma", "par", "10" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		pb.inheritIO();

		try {
			Process proceso = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ejecutaSubprocesoProcesoJava() {
		String[] comando = { "java", "-cp", "target/classes", "boletin1.CalculaSuma", "impar", "11" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		pb.inheritIO();

		try {
			Process proceso = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
