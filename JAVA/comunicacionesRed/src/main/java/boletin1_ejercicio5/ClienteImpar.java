package boletin1_ejercicio5;

import java.io.*;
import java.net.Socket;

public class ClienteImpar {
	public static void main(String[] args) {
		String nombre = "IMPAR";
		String archivo = "impar.txt";
		int puerto = 6666;

		try (Socket socket = new Socket("localhost", puerto);
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader fichero = new BufferedReader(new FileReader(archivo))) {

			String linea;
			boolean continuar = true;

			while (continuar && (linea = fichero.readLine()) != null) {
				salida.println(linea);

				String respuesta = entrada.readLine();
				System.out.println("CLIENTE " + nombre + ": recibido -> " + respuesta);

				if (respuesta.equals("ACIERTO") || respuesta.contains("terminado")) {
					continuar = false;
				}

				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.err.println("Error en Cliente IMPAR: " + e.getMessage());
		}
	}
}