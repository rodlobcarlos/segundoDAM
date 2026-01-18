package ejercicio4_controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import ejercicio4_modelo.PeticionWeb;

public class GestionaAccesoServidorWeb {

	public static void main(String[] args) {

		Semaphore request = new Semaphore(12);
		
		List<Thread> list = new ArrayList<Thread>();
		PeticionWeb peticionWeb = new PeticionWeb(request);
		
		for(int i = 1; i <= 20; i++) {
			Thread hilo = new Thread(peticionWeb, " Petcion web " + i);
			list.add(hilo);
			hilo.start();
		}
		
		for(Thread thread: list) {
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
