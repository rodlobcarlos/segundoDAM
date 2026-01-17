package controlador;

import hilos.Hilo_runnable;

public class Gestor_runnable {

	public static void main(String[] args) {

		Hilo_runnable runnable1 = new Hilo_runnable("España");
		Hilo_runnable runnable2 = new Hilo_runnable("Estados Unidos");
		
		// Invoca thread para los hilos
		Thread hilo1 = new Thread(runnable1);
		Thread hilo2 = new Thread(runnable2);
		
		hilo1.start();
		hilo2.start();
	}

}
