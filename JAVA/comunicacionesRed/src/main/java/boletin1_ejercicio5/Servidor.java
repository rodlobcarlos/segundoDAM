package boletin1_ejercicio5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		Numero numero = new Numero();
		int puerto = 6666;

		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor: ...");

			while (true) {
				Socket socketCliente = servidor.accept();
				// Pasamos el contador y el tablero único al hilo
				new ServidorHilo(numero, socketCliente).start();
			}
		} catch (IOException e) {
			System.err.println("Error en el servidor: " + e.getMessage());
		}
	}
}
