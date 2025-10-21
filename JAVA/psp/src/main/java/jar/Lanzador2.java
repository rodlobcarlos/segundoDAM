package jar;

import java.io.IOException;

import boletin1.LanzadorCalculaSuma;

public class Lanzador2 {

	public void ejecutaProcesoJava() {
		String[] comando = { "java", "-jar", "target\\ejercicio.jar"};
		ProcessBuilder pb = new ProcessBuilder(comando);
		pb.inheritIO();

		try {
			Process proceso = pb.start();
			pb.inheritIO();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		Lanzador2 l = new Lanzador2  ();
		l.ejecutaProcesoJava();
	}

}
