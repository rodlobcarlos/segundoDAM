package boletin1_ejercicio5;

import java.io.*;
import java.net.Socket;

public class ClientePar {
	public static void main(String[] args) {
		String nombre = "PAR";
		String archivo = "par.txt";
		int puerto = 6666;

		// LOGICA: Se establece la conexión TCP con el servidor y se preparan los flujos:
		// 'salida' para enviar datos, 'entrada' para recibir del servidor y 'fichero' para leer los números locales.
		try (Socket socket = new Socket("localhost", puerto);
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader fichero = new BufferedReader(new FileReader(archivo))) {

			String linea;
			boolean continuar = true;

			// LOGICA: El bucle principal se mantiene activo mientras queden números en el archivo
			// y la variable 'continuar' no cambie a false (lo que indicaría fin de juego).
			while (continuar && (linea = fichero.readLine()) != null) {
				
				// LOGICA: Envía al servidor el número leído desde el archivo par.txt.
				salida.println(linea);

				// LOGICA: Se detiene a esperar la respuesta del servidor (ACIERTO, MAYOR, MENOR o TERMINADO).
				String respuesta = entrada.readLine();
				
				// LOGICA: Muestra por pantalla la respuesta recibida para que el usuario pueda seguir el juego.
				System.out.println("CLIENTE " + nombre + ": recibido -> " + respuesta);

				// LOGICA: Condición de parada. Si el cliente acierta el número o el servidor le indica
				// que el juego ha finalizado (porque otro acertó), cambia 'continuar' a false para salir del bucle.
				if (respuesta.equals("ACIERTO") || respuesta.contains("terminado")) {
					continuar = false;
				}

				// LOGICA: Introduce un pequeño retardo para que la ejecución no sea instantánea 
				// y se puedan leer los mensajes en consola cómodamente.
				Thread.sleep(500); 
			}
		} catch (Exception e) {
			// LOGICA: Captura problemas de conexión o errores al abrir el archivo par.txt.
			System.err.println("Error en Cliente PAR: " + e.getMessage());
		}
	}
}