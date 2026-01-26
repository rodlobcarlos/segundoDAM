package boletin1_ejercicio2;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilo extends Thread {
//	public static void main(String[] args) {
	String host = "localhost";
	int puerto = 4444; //

	@Override
	public void run() {
		try (Socket socket = new Socket(host, puerto); // Conexión
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				Scanner sc = new Scanner(System.in)) {
			/*
			 * String texto = "";
			 * 
			 * 
			 * while (true) { System.out.println("Escribe algo: "); texto = sc.nextLine();
			 * 
			 * salida.println(texto);
			 * 
			 * // Leemos el saludo inicial del servidor multihilo String saludo =
			 * entrada.readLine(); System.out.println("Servidor dice: " + saludo); }
			 */

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Cliente : Conexión cerrada.");
	}

}
