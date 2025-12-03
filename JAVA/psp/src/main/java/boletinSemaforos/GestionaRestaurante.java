package boletinSemaforos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante {

	public static void main(String[] args) {
//		Semaphore s = new Semaphore(3);
		Semaphore s = new Semaphore(2);
		try {
			s.acquire(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Thread> hilos = new ArrayList<Thread>();
		Cocinero cocinero = new Cocinero("Cocinero", s);
		Thread hilo2 = new Thread(cocinero);
		hilos.add(hilo2);

		for (int i = 0; i <= 3; i++) {
			ComensalesHilo comensal = new ComensalesHilo("Comemsal " + i, s);
			Thread hilo1 = new Thread(comensal);
			hilos.add(hilo1);
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
	}

}
