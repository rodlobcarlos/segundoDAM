package boletinSemaforos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaAccesoServidorWeb {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(12);
		
		List<Thread> hilos = new ArrayList<Thread>();
		
		for(int i = 0; i <= 20; i++) {
			PeticionWeb peticion = new PeticionWeb("Petición" +i, s);
			Thread hilo = new Thread(peticion);
			hilos.add(hilo);
		}
		
		for(Thread thread: hilos) {
			thread.start();
		}
		
		for(Thread thread: hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
