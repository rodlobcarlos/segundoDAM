package conexion;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int Puerto = 6000;// puerto remoto en el servidor que el cliente conoce
		Socket cliente = new Socket(Host, Puerto);// conecta

		InetAddress i = cliente.getInetAddress();
		System.out.println("Puerto local: " + cliente.getLocalPort());
		System.out.println("Puerto Remoto: " + cliente.getPort());
		System.out.println("Host Remoto: " + i.getHostName().toString());
		System.out.println("IP Host Remoto: " + i.getHostAddress().toString());
	}

}
