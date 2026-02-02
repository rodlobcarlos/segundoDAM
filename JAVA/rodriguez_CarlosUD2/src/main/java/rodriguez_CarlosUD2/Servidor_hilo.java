package rodriguez_CarlosUD2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Servidor_hilo extends Thread {

	// 1. ATRIBUTO: Variable para guardar la conexión de cada cliente específico
	private Socket socket;
	private Map<String, String> votos;

	// 2. CONSTRUCTOR: Recibe el socket desde el Servidor y lo asigna a la clase
	public Servidor_hilo(Socket socket) {
		super();
		this.socket = socket;
		this.votos = new HashMap<String, String>();
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Map<String, String> getVotos() {
		return votos;
	}

	public void setVotos(Map<String, String> votos) {
		this.votos = votos;
	}

	@Override
	public void run() {
		// Usamos el socket que recibimos en el constructor
		try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);) {

			// 3. SALUDO: Mensaje inicial al conectarse
			salida.println("Conexión establecida");
			String mensajeCliente = entrada.readLine();
			mensajeCliente.split(":::");
			votos.put(mensajeCliente, mensajeCliente);
			System.out.println("Voto registrado." + votos.keySet());

		} catch (IOException e) {
			System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
		}
	}
}
