package boletin1_ejercicio3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		Contador contador = new Contador();
		int puerto = 4444;
		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor multihilo iniciado en el puerto " + puerto);
			while (true) {
				// 1. Espera a un cliente
				Socket socketCliente = servidor.accept();
				System.out.println("Nuevo cliente conectado: " + socketCliente.getInetAddress());
				// 2. Lanza un hilo nuevo para este cliente específico
				// Esto permite que el bucle vuelva al accept() inmediatamente
				new Servidor_hilo(socketCliente, contador).start();
			}
		} catch (IOException e) {
			System.err.println("Error en el servidor: " + e.getMessage());
		}
	}
}
