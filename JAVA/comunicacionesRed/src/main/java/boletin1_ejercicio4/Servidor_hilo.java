package boletin1_ejercicio4;

import java.io.*;
import java.net.Socket;

public class Servidor_hilo extends Thread {
    private Contador contador;
    private Socket socket;
    private Tablero tablero;
    private int idCliente;

    public Servidor_hilo(Contador contador, Socket socket, Tablero tablero) {
        this.contador = contador;
        this.socket = socket;
        this.tablero = tablero;
    }

    @Override
    public void run() {
        this.idCliente = contador.conexionesTotales();
        System.out.println("Cliente conectado => " + idCliente);

        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            // 1. Enviar ID al cliente
            salida.println(idCliente);

            // 2. Enviar si el juego continúa
            if (tablero.getPremiosRestantes() <= 0) {
                salida.println("SIN_PREMIOS");
                socket.close();
                return;
            } else {
                salida.println("JUEGO_ACTIVO");
            }

            String mensaje;
            // Bucle de juego: mientras queden premios y el cliente envíe datos
            while (tablero.getPremiosRestantes() > 0 && (mensaje = entrada.readLine()) != null) {
                try {
                    // Esperamos formato "fila,columna" (ej: "1,1")
                    String[] coordenadas = mensaje.split(",");
                    int f = Integer.parseInt(coordenadas[0].trim());
                    int c = Integer.parseInt(coordenadas[1].trim());

                    String resultado = tablero.intentarCapturarPremio(f, c);

                    if (resultado.equals("ERROR_RANGO")) {
                        salida.println("Error: Posición fuera de rango (F:1-3, C:1-4)");
                    } else if (resultado.equals("NADA")) {
                        salida.println("En la posición [" + f + "," + c + "] no hay premio.");
                    } else {
                        salida.println("¡PREMIO! Has encontrado: " + resultado);
                    }

                    // Notificar si ya no quedan más premios tras esta jugada
                    if (tablero.getPremiosRestantes() <= 0) {
                        salida.println("FIN_DEL_JUEGO");
                        break;
                    } else {
                        salida.println("CONTINUA");
                    }

                } catch (Exception e) {
                    salida.println("Error de formato. Usa: fila,columna");
                }
            }
        } catch (IOException e) {
            System.err.println("Error con cliente " + idCliente + ": " + e.getMessage());
        } finally {
            System.out.println("Cliente desconectado => " + idCliente);
            try { socket.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}