package boletin1_ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servidor_hilo extends Thread {

	private Contador contador;

	// 1. ATRIBUTO: Variable para guardar la conexión de cada cliente específico
	private Socket socket;

	// 2. CONSTRUCTOR: Recibe el socket desde el Servidor y lo asigna a la clase
	public Servidor_hilo(Socket socket, Contador contador) {
		super();
		this.contador = contador;
		this.socket = socket;
	}

	@Override
	public void run() {
		// Usamos el socket que recibimos en el constructor
		try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);) {

			// 3. SALUDO: Mensaje inicial al conectarse
			salida.println("Bienvenido cliente: " + contador.getNumero_total_conexiones());
			contador.setNumero_total_conexiones(contador.getNumero_total_conexiones()+1);

		} catch (IOException e) {
			System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
		}
	}

}
