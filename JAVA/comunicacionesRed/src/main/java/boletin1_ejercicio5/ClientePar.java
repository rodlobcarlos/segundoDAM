package boletin1_ejercicio5;

import java.io.*;
import java.net.Socket;

public class ClientePar {
	public static void main(String[] args) {
		String nombre = "PAR";
		String archivo = "par.txt";
		int puerto = 6666;

		try (Socket socket = new Socket("localhost", puerto);
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader fichero = new BufferedReader(new FileReader(archivo))) {

			String linea;
			boolean continuar = true;

			while (continuar && (linea = fichero.readLine()) != null) {
				// Enviamos el número al servidor
				salida.println(linea);

				// Leemos la respuesta
				String respuesta = entrada.readLine();
				System.out.println("CLIENTE " + nombre + ": recibido -> " + respuesta);

				// Si acertamos o el servidor dice que terminó, cerramos
				if (respuesta.equals("ACIERTO") || respuesta.contains("terminado")) {
					continuar = false;
				}

				Thread.sleep(500); // Pausa para ver los mensajes poco a poco
			}
		} catch (Exception e) {
			System.err.println("Error en Cliente PAR: " + e.getMessage());
		}
	}
}