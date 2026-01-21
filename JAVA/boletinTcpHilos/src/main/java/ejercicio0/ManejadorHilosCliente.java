package ejercicio0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorHilosCliente extends Thread {

	private Socket socket;

	public ManejadorHilosCliente(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
	    try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	         PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {
	        
	        salida.println("Bienvenido...");
	        String mensaje;
	        while ((mensaje = entrada.readLine()) != null && !mensaje.equalsIgnoreCase("fin")) {
	            System.out.println("Cliente dice: " + mensaje);
	            salida.println("ECO: " + mensaje.toUpperCase());
	        }
	    } catch (IOException e) {
	        System.out.println("El cliente se desconectó bruscamente.");
	    } finally {
	        try {
	            socket.close();
	        } catch (IOException e) { e.printStackTrace(); }
	    }
	}
}
