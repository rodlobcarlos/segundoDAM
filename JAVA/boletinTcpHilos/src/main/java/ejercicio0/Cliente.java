package ejercicio0;

import java.io.IOException;
import java.net.Socket;

public class Cliente extends Thread {
    private Socket socket;

    public Cliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String ipCliente = socket.getInetAddress().getHostAddress();
        
        System.out.println("Conexión establecida con: " + ipCliente);

        try {
            // Dormir el hilo durante 5 segundos
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Hilo interrumpido.");
        } finally {
            // Cerrar el socket y avisar
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Conexión finalizada con: " + ipCliente);
        }
    }
}