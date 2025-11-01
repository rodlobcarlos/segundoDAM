package notes;

import java.io.IOException;

public class Processbuilder {

	public static void main(String[] args) {

		String[] comando = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};
		ProcessBuilder pb = new ProcessBuilder(comando);
		Process proceso;
		try {
			proceso = pb.start(); // Empieza el proceso
			int salidaEstado = proceso.waitFor();
			System.out.println(salidaEstado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
