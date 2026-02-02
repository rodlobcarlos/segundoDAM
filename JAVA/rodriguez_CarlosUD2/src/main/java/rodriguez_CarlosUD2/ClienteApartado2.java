package rodriguez_CarlosUD2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ClienteApartado2 extends Thread {

	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 5555;

		try (Socket socket = new Socket(host, puerto); // Conexión
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				Scanner sc = new Scanner(System.in)) {

			System.out.println("Cliente : Conectado al servidor.");

			Random random = new Random();
			int numero = random.nextInt(100000);
			ClienteApartado2 votos = new ClienteApartado2();
			
			String saludo = entrada.readLine();
			System.out.println("Servidor dice: " + saludo);
			while (saludo != null) {
				String mensajeCliente = "DNI " + numero + ":::" + votos.generaVoto();
				salida.println(mensajeCliente);
			}

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Cliente : Conexión cerrada.");
	}

	public String generaVoto() {
		Random random = new Random();
		Candidato[] valores = Candidato.values();
		int pos = random.nextInt(valores.length);
		return valores[pos].name();
	}
}
