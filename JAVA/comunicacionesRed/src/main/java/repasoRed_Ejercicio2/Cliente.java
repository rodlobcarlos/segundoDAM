package repasoRed_Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {

		String host = "localhost";
		int puerto = 4444; //

		try (Socket socket = new Socket(host, puerto); // Conexión
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); //
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); //
				Scanner sc = new Scanner(System.in)) {
				
			System.out.println("Cliente conectado.");

			String repuestaServidor = entrada.readLine();
			System.out.println(repuestaServidor);

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Cliente : Conexión cerrada.");
	}

}
