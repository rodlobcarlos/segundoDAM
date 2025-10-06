package boletin1;

import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] comando = { "C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			Process p = pb.start();
			pb.start(); // Se abre otra vez el chrome;
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
