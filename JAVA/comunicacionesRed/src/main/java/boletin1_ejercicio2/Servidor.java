package boletin1_ejercicio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Servidor {
	public static void main(String[] args) {
		int puerto = 4444;
		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor iniciado...");
			while (true) {
				// 1. Espera a un cliente
				Socket socketCliente = servidor.accept();
				System.out.println("Conecta IP " + socketCliente.getInetAddress() + ", Puerto remoto: " + socketCliente.getPort());
				// 2. Lanza un hilo nuevo para este cliente específico
				// Esto permite que el bucle vuelva al accept() inmediatamente
				new Servidor_hilo(socketCliente).start();
			}
		} catch (IOException e) {
			System.err.println("Error en el servidor: " + e.getMessage());
		}
	}
}
