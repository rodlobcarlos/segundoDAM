package boletin1Hilos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que gestiona la simulación de múltiples cuidadores
 * alimentando a una mascota de forma concurrente.
 */
public class GestionaMascota {

	public static void main(String[] args) {

		// Crear una mascota llamada "Lulu" con un contador inicial de 10 alimentaciones
		MascotaHilo mascota = new MascotaHilo("Lulu", 10);
		
		// Lista para almacenar los hilos de los cuidadores
		List<Thread> listaCuidadores = new ArrayList<Thread>();
		
		// Crear 5 hilos (cuidadores) que compartirán la misma mascota
		for(int i = 1; i <= 5; i++) {
			// Cada hilo ejecutará el método run() de la mascota
			Thread cuidador = new Thread(mascota, " Cuidador" + i);
			listaCuidadores.add(cuidador);
			// Iniciar la ejecución del hilo
			cuidador.start();
		}
		
		// Esperar a que todos los hilos terminen su ejecución
		for(Thread thread: listaCuidadores) {
			try {
				// join() bloquea hasta que el hilo termine
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Imprimir el número total de veces que la mascota fue alimentada
		System.out.println("Lulu ha comido: " + mascota.getVecesAlimentado() + " veces");
	}

}