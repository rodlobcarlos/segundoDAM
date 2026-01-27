package boletin1_ejercicio5;

import java.io.*;
import java.net.Socket;

public class ServidorHilo extends Thread {
	private Numero numeroCompartido;
	private Socket socket;

	public ServidorHilo(Numero numero, Socket socket) {
		this.numeroCompartido = numero;
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

			String mensajeCliente;
			while ((mensajeCliente = entrada.readLine()) != null) {
				// 1. Comprobar si alguien ya ganó antes de procesar
				if (numeroCompartido.isAcertado()) {
					salida.println("SERVIDOR: El juego ha terminado, otro cliente acertó.");
					break;
				}

				int intento = Integer.parseInt(mensajeCliente);
				String prefijo;

				if (intento % 2 == 0) {
					prefijo = "SERVIDOR (PAR): ";
				} else {
					prefijo = "SERVIDOR (IMPAR): ";
				}

				// 2. Comparar número
				if (intento == numeroCompartido.getNumero()) {
					numeroCompartido.setAcertado(true);
					salida.println("ACIERTO");
					System.out.println(prefijo + "ACIERTO");
				} else if (numeroCompartido.getNumero() > intento) {
					salida.println("MAYOR");
					System.out.println(prefijo + "MAYOR");
				} else {
					salida.println("MENOR");
					System.out.println(prefijo + "MENOR");
				}
			}
		} catch (IOException e) {
			System.out.println("Finalizada conexión con cliente.");
		}
	}
}