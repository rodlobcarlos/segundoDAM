package boletin1_ejercicio5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		// LOGICA: Se inicializa el objeto que contiene el número secreto. 
		// Al ser único, todos los hilos compartirán este mismo número.
		Numero numero = new Numero();
		int puerto = 6666;

		// LOGICA: Se abre el puerto de escucha para permitir conexiones TCP.
		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor: ...");

			// LOGICA: El servidor entra en un bucle infinito para mantenerse activo
			// y poder recibir múltiples clientes uno tras otro.
			while (true) {
				// LOGICA: El programa se detiene aquí hasta que un cliente intenta conectar.
				// Cuando esto ocurre, se acepta la conexión y se crea un canal (Socket).
				Socket socketCliente = servidor.accept();
				
				// LOGICA: Para no bloquear al siguiente cliente, se delega la atención 
				// de este usuario a un hilo nuevo. Se le pasa el objeto 'numero' 
				// para que todos los hilos vean si alguien ya ha acertado.
				new ServidorHilo(numero, socketCliente).start();
			}	
		} catch (IOException e) {
			// LOGICA: Gestión de errores en caso de que el puerto esté ocupado o falle la red.
			System.err.println("Error en el servidor: " + e.getMessage());
		}
	}
}