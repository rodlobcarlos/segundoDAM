package conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) {
		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int Puerto = 6000;// puerto remoto en el servidor que el cliente conoce
		Socket cliente;
		try {
			cliente = new Socket(Host, Puerto);
			// conecta
//			InetAddress i = cliente.getInetAddress();
//			System.out.println("Puerto local: " + cliente.getLocalPort());
//			System.out.println("Puerto Remoto: " + cliente.getPort());
//			System.out.println("Host Remoto: " + i.getHostName().toString());
//			System.out.println("IP Host Remoto: " + i.getHostAddress().toString());

			// Configura flujos para enviar y recibir datos
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String mensajeParaServidor = "Hola soy un cliente";

			// Enviar mensaje al servidor
			salida.println(mensajeParaServidor);
			System.out.println("Mensaje enviado. Esperando respuesta del servidor...");

			String repuestaServidor = entrada.readLine();
			while (repuestaServidor != null) {
				if (repuestaServidor == "fin") {
					System.out.println("Respuesta del servidor: " + repuestaServidor);
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
