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
		// LOGICA: Se preparan los canales de comunicación (entrada para leer al cliente, salida para responderle).
		try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

			String mensajeCliente;
			boolean continuar = true;
			// LOGICA: El hilo escucha constantemente los mensajes enviados por su cliente asignado.
			while (continuar && (mensajeCliente = entrada.readLine()) != null) {
				
				// LOGICA: Antes de procesar el número, revisa el objeto compartido para ver si 
				// otro cliente (en otro hilo) ya adivinó el número secreto.
				if (numeroCompartido.isAcertado()) {
					// LOGICA: Si el juego terminó, informa al cliente y rompe el bucle para cerrar la conexión.
					salida.println("SERVIDOR: El juego ha terminado, otro cliente acertó.");
					continuar = false;
				}

				// LOGICA: Convierte el texto recibido en un número entero para poder compararlo.
				int intento = Integer.parseInt(mensajeCliente);
				String prefijo;

				// LOGICA: Identifica visualmente en la consola del servidor si el intento proviene del cliente par o impar.
				if (intento % 2 == 0) {
					prefijo = "SERVIDOR (PAR): ";
				} else {
					prefijo = "SERVIDOR (IMPAR): ";
				}

				// LOGICA: Compara el intento del cliente con el número secreto guardado en el objeto compartido.
				if (intento == numeroCompartido.getNumero()) {
					// LOGICA: Si acierta, actualiza el estado global a 'true' para que los demás hilos sepan que el juego terminó.
					numeroCompartido.setAcertado(true);
					salida.println("ACIERTO");
					System.out.println(prefijo + "ACIERTO");
				} else if (numeroCompartido.getNumero() > intento) {
					// LOGICA: Si el secreto es más grande, da una pista al cliente.
					salida.println("MAYOR");
					System.out.println(prefijo + "MAYOR");
				} else {
					// LOGICA: Si el secreto es más pequeño, da una pista al cliente.
					salida.println("MENOR");
					System.out.println(prefijo + "MENOR");
				}
			}
		} catch (IOException e) {
			// LOGICA: Se ejecuta cuando el cliente cierra la conexión o hay un error en la red.
			System.out.println("Finalizada conexión con cliente.");
		}
	}
}