package taller_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import taller_model.Coche;
import taller_model.Mecanico;
import taller_model.MecanicoNuevo;

public class GestionaTaller {

	public static void main(String[] args) {

		Semaphore s_reparar = new Semaphore(0);

		List<Thread> hilos = new ArrayList<Thread>();
		Mecanico mecanico = new Mecanico("Mecanico ", s_reparar, 5, 20);
		Thread hilo1 = new Thread(mecanico);
		hilos.add(hilo1);
		hilo1.start();
		
//		MecanicoNuevo nuevo = new MecanicoNuevo("Mecanico nuevo", s_reparar, 8, 20);
//		Thread hilo3 = new Thread(nuevo);
//		hilos.add(hilo3);
//		hilo3.start();

		for (int i = 1; i < 21; i++) {
			Coche coche = new Coche("Coche " + i, s_reparar);
			Thread hilo2 = new Thread(coche);
			hilos.add(hilo2);
			hilo2.start();

		}

		for (Thread thread : hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Ha tardado en raparar todos los coches... " + mecanico.getTiempoTotal() + " segundos");
//		System.out.println("Ha tardado en raparar todos los coches... " + nuevo.sumarTiempo2() + " segundos");
	}

}
