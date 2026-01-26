package boletin1_ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class Servidor_hilo extends Thread {

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

			String mensaje;
			while ((mensaje = entrada.readLine()) != null) {
				System.out.println("Cliente dice: " + mensaje); // Imprime en consola del servidor
				salida.println("ECO " + mensaje); // Responde al cliente
			}
			
			// 3. SALUDO: Mensaje inicial al conectarse
			salida.println("Conexión establecida. " + socket.getInetAddress() + LocalDateTime.now());
			System.out.println("Conexión finalizada. " + socket.getInetAddress() + LocalDateTime.now());
		} catch (IOException e) {
			System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
		}
	}

}
