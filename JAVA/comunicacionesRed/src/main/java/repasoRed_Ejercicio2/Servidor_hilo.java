package repasoRed_Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servidor_hilo extends Thread{

	// 1. ATRIBUTO: Variable para guardar la conexión de cada cliente específico
	private Socket socket;

	// 2. CONSTRUCTOR: Recibe el socket desde el Servidor y lo asigna a la clase
	public Servidor_hilo(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// Usamos el socket que recibimos en el constructor
		try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);) {

			salida.println("El servidor le da la bienvenda al cliente");
			System.out.println("Cliente desconectado " + socket.getInetAddress() + " " + socket.getPort());

		} catch (IOException e) {
			System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
		}
	}
}
