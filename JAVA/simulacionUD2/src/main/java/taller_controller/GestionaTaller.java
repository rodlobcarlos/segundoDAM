package taller_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import taller_model.Coche;
import taller_model.Mecanico;

public class GestionaTaller {

	public static void main(String[] args) {

		Semaphore s_reparar = new Semaphore(0);

		List<Thread> hilos = new ArrayList<Thread>();
		Mecanico mecanico = new Mecanico("Mecanico ", s_reparar, 120);
		Thread hilo1 = new Thread(mecanico);
		hilos.add(hilo1);

		for (int i = 0; i <= 20; i++) {
			Coche coche = new Coche("Coche " + i, s_reparar);
			Thread hilo2 = new Thread(coche);
			hilos.add(hilo2);
		}

		for (Thread thread : hilos) {
			thread.start();
		}

		for (Thread thread : hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Ha tardado en raparar todos los coches... " + mecanico.tiempoTotal() + " minutosz");
	}

}
