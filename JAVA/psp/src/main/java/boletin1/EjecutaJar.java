package boletin1;

import java.io.IOException;

public class EjecutaJar {
	
	public void ejecutaProcesoJava() {
		String[] comando = { "java", "-jar", "target\\ejercicio.jar"};
		ProcessBuilder pb = new ProcessBuilder(comando);

		try {
			pb.inheritIO();
			Process proceso = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
