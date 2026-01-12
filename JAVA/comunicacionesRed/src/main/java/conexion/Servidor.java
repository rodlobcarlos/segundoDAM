package conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Definir el puerto (identifica la aplicación en la máquina)
		int puerto = 6000;
		ServerSocket servidor = null;
		Socket clienteConectado = null;

		try {
			// Crear el ServerSocket para escuchar peticiones
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor escuchando en el puerto " + puerto);
			Socket cliente = servidor.accept();
			System.out.println("Nuevo cliente conectado: " + cliente.getInetAddress());

			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

			String mensajeCliente = entrada.readLine();
			System.out.println("Servidor-> Cliente dice: " + mensajeCliente);

			String miRespuesta = "";
			while (miRespuesta != "fin") {
				miRespuesta = sc.nextLine();
				salida.println(miRespuesta);
				System.out.println("Servidor-> Cliente nuevo dice: " + miRespuesta);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();
	}
}
