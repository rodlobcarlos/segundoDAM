package boletin1_ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHilo extends Thread {

	private Numero numero;
	private Socket socket;

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public String toString() {
		return "ServidorHilo [numero=" + numero + ", socket=" + socket + "]";
	}

	public ServidorHilo(Numero numero, Socket socket) {
		super();
		this.numero = numero;
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("Cliente conectado: " + socket.getInetAddress());
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

			while((entrada.readLine() != null) && numero.getNumero() >= 0 && numero.getNumero() <= 20) {
				if(entrada.read() == numero.getNumero()) {
					salida.println("Has acertado el número secreto!!!");
				}else {
					salida.println("Numero incorrecto, sigue intentandolo.");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
