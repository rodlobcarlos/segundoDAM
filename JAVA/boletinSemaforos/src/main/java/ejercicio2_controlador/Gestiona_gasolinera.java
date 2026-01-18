package ejercicio2_controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import ejercicio2_modelo.Coche;

public class Gestiona_gasolinera {

	public static void main(String[] args) {
		// Entran 3 coches
		Semaphore repostar = new Semaphore(3);

		List<Thread> list = new ArrayList<Thread>();
		Coche coche = new Coche(repostar);

		for (int i = 0; i <= 8; i++) {
			Thread hilo = new Thread(coche, " Coche " + i);
			list.add(hilo);
			hilo.start();
		}

		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Fin del programa.");
	}
}
