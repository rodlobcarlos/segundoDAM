package pruebaPractica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProcesoPadre {
	
	private static final String rutaResource = "src\\main\\resources\\";
	private static final String diractorioGenerarClasses = "target\\classes";
	private static final String rutaFicherosJava = "src\\main\\java\\pruebaPractica\\ProcesoHijo.java";
	
	public static void main(String[] args) {
		String[] sensor = {"TEMPERATURA","PRESION","HUMEDAD"};
		ProcesoPadre a = new ProcesoPadre();
		a.compilaClaseJava();
		for(String s: sensor) {
			a.ejecutaProcesoJava(s);
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
	
	public void ejecutaProcesoJava(String nombreSensor) {
		String[] comando = { "java", "-cp", diractorioGenerarClasses,
				rutaFicherosJava, nombreSensor, "fichero.txt" };
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
