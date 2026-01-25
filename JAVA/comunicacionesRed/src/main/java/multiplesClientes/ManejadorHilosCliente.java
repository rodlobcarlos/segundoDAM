package multiplesClientes;

import java.io.*;
import java.net.Socket;

// La clase extiende de Thread para poder ejecutarse en paralelo
public class ManejadorHilosCliente extends Thread {

	// 1. ATRIBUTO: Variable para guardar la conexión de cada cliente específico
	private Socket socket;

	// 2. CONSTRUCTOR: Recibe el socket desde el Servidor y lo asigna a la clase
	public ManejadorHilosCliente(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// Usamos el socket que recibimos en el constructor
		try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);) {
			
			// 3. SALUDO: Mensaje inicial al conectarse
			salida.println("Bienvenido. Escribe algo (o 'fin' para salir):");

			String mensaje;
			// 4. BUCLE: Lee mensajes mientras no sea "fin" o nulo
			while ((mensaje = entrada.readLine()) != null && !mensaje.equalsIgnoreCase("fin")) {
				System.out.println("Cliente dice: " + mensaje); // Imprime en consola del servidor
				salida.println("Servidor responde: " + mensaje.toUpperCase()); // Responde al cliente
			}

			// 5. CIERRE: Si el mensaje es "fin", enviamos despedida
			if (mensaje != null && mensaje.equalsIgnoreCase("fin")) {
				salida.println("Cerrando sesión. ¡Hasta pronto!");
			}

		} catch (IOException e) {
			System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
		}
	}
}