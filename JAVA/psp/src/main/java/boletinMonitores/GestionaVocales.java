package boletinMonitores;

import java.util.ArrayList;
import java.util.List;

public class GestionaVocales {

	public static void main(String[] args) {

		String texto = "La programación concurrente con hilos en Java es muy interesante "
				+ "y permite realizar múltiples tareas simultáneamente. "
				+ "El uso de métodos sincronizados evita condiciones de carrera.";

		char[] vocales = { 'a', 'e', 'i', 'o', 'u' };

		List<Thread> hilos = new ArrayList<Thread>();

		for (char vocal : vocales) {
			HiloVocales contador = new HiloVocales(texto, vocal);
			
			Thread hilo = new Thread(contador, "Hilo-" + vocal);
			
			hilos.add(hilo);
			hilo.start();
		}
		
		for(Thread thread: hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Total de vocales encontradas: " + HiloVocales.getVocalesTotales());	}

}
