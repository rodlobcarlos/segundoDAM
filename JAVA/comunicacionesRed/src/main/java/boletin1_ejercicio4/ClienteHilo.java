package boletin1_ejercicio4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilo {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 4444;

        try (Socket socket = new Socket(host, puerto);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            // Leer ID asignado
            String id = entrada.readLine();
            System.out.println("Tu ID de cliente es: " + id);

            // Leer si el juego está activo
            String estadoJuego = entrada.readLine();
            if (estadoJuego.equals("SIN_PREMIOS")) {
                System.out.println("Lo siento, ya no quedan premios. Cerrando...");
                return;
            }

            System.out.println("--- JUEGO DE LOS PREMIOS (Tablero 3x4) ---");
            
            while (true) {
                System.out.print("Introduce fila y columna (ej: 1,1): ");
                String jugada = sc.nextLine();
                salida.println(jugada);

                // Leer resultado de la jugada
                String respuesta = entrada.readLine();
                System.out.println("Servidor: " + respuesta);

                // Leer si el juego ha terminado
                String control = entrada.readLine();
                if (control == null || control.equals("FIN_DEL_JUEGO")) {
                    System.out.println("El juego ha terminado. ¡Gracias por participar!");
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}