package controlador;

import hilos.Hilo_thread;

public class Gestor_thread {

	public static void main(String[] args) {

		// Hilos
		Hilo_thread hilo1 = new Hilo_thread("Soy el hilo 1");
		Hilo_thread hilo2 = new Hilo_thread("Soy el hilo 2");

		// Empiezan los hilos
		hilo1.start();
		hilo2.start();
		
	}

}
