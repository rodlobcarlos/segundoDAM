package boletin1_ejercicio5;

import java.io.*;
import java.net.Socket;

public class ClienteImpar {
	public static void main(String[] args) {
		String nombre = "IMPAR";
		String archivo = "impar.txt";
		int puerto = 6666;

		// LOGICA: Se inicia la conexión con el servidor en el puerto 6666.
		// Se preparan los flujos para enviar texto (salida), recibir texto (entrada) 
		// y leer el archivo local de números impares línea por línea.
		try (Socket socket = new Socket("localhost", puerto);
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader fichero = new BufferedReader(new FileReader(archivo))) {

			String linea;
			boolean continuar = true;

			// LOGICA: Mientras el archivo tenga números y nadie haya ganado aún, el cliente sigue intentando.
			while (continuar && (linea = fichero.readLine()) != null) {
				
				// LOGICA: Se envía el número impar leído del fichero directamente al servidor.
				salida.println(linea);

				// LOGICA: El programa se queda esperando la contestación del servidor antes de seguir.
				String respuesta = entrada.readLine();
				
				// LOGICA: Imprime por consola lo que el servidor ha respondido para que podamos ver el progreso.
				System.out.println("CLIENTE " + nombre + ": recibido -> " + respuesta);

				// LOGICA: Si la respuesta es "ACIERTO" (este cliente ganó) o contiene "terminado" 
				// (otro cliente ganó), se cambia el control para detener el bucle y cerrar la conexión.
				if (respuesta.equals("ACIERTO") || respuesta.contains("terminado")) {
					continuar = false;
				}

				// LOGICA: Pausa de medio segundo para que los intentos no ocurran demasiado rápido 
				// y la consola sea legible.
				Thread.sleep(500);
			}
		} catch (Exception e) {
			// LOGICA: Si el archivo 'impar.txt' no existe o el servidor está apagado, se muestra el error aquí.
			System.err.println("Error en Cliente IMPAR: " + e.getMessage());
		}
	}
}