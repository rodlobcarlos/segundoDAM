package boletin1_ejercicio4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Tablero tableroCompartido = new Tablero(); // Un solo tablero para todos
        int puerto = 4444;
        
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado...\n"
                    + "Posiciones con premio: [1,1][2,3][3,1][3,4]");
            
            while (true) {
                Socket socketCliente = servidor.accept();
                // Pasamos el contador y el tablero único al hilo
                new Servidor_hilo(contador, socketCliente, tableroCompartido).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}