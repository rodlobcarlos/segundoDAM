package boletinHilos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que gestiona la simulación de múltiples cuidadores
 * alimentando a una mascota de forma concurrente, usando prioridades de hilos.
 * 
 * Este programa demuestra el uso de prioridades en hilos, donde cada cuidador
 * tiene una prioridad diferente que influye (pero no garantiza) el orden de ejecución.
 */
public class GestionaMascotas {
	
	public static void main(String[] args) {
		
		// Crear una mascota llamada "Lulú"
		Mascota mascota = new Mascota("Lulú");
		
		// Lista para almacenar los 10 hilos de cuidadores
		List<Thread> cuidadores = new ArrayList<Thread>();
		
		// Crear 10 hilos (cuidadores) que compartirán la misma mascota
		for(int i = 1; i <= 10; i++) {
			// Cada hilo ejecutará el método run() de la mascota
			Thread cuidador = new Thread(mascota, "Cuidador" + i);
			cuidadores.add(cuidador);
			
			// NOTA: Este bloque if-else se ejecuta pero es sobrescrito inmediatamente
			// después por el setPriority(11-i), por lo que NO tiene efecto real
			if(i % 2 == 0) {
				// Cuidadores pares: prioridad máxima (10)
				cuidador.setPriority(cuidador.MAX_PRIORITY);
			} else {
				// Cuidadores impares: prioridad mínima (1)
				cuidador.setPriority(cuidador.MIN_PRIORITY);
			}
			
			// ESTE es el setPriority que realmente se aplica (sobrescribe el anterior)
			// Asigna prioridades de forma descendente:
			// Cuidador1 = 10, Cuidador2 = 9, Cuidador3 = 8, ..., Cuidador10 = 1
			cuidador.setPriority(11 - i);
			
			// Iniciar la ejecución del hilo
			cuidador.start();
		}
		
		// Esperar a que todos los hilos terminen su ejecución
		for(Thread thread: cuidadores) {
			try {
				// join() bloquea el hilo principal hasta que cada cuidador termine
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Imprimir el número total de veces que la mascota fue alimentada
		// Debería ser 10 si el método está sincronizado correctamente
		System.out.println(mascota.getNumVecesAlimentado());
	}
}

/**
 * NOTAS SOBRE PRIORIDADES:
 * 
 * 1. Las prioridades van de 1 (MIN_PRIORITY) a 10 (MAX_PRIORITY), siendo 5 la normal.
 * 
 * 2. El primer setPriority (dentro del if-else) NO tiene efecto porque es
 *    inmediatamente sobrescrito por setPriority(11-i).
 * 
 * 3. Las prioridades finales son:
 *    - Cuidador1: prioridad 10 (más alta)
 *    - Cuidador2: prioridad 9
 *    - Cuidador3: prioridad 8
 *    - ...
 *    - Cuidador10: prioridad 1 (más baja)
 * 
 * 4. IMPORTANTE: Las prioridades son SUGERENCIAS al sistema operativo, no garantías.
 *    El orden real de ejecución puede variar según el SO y la carga del sistema.
 * 
 * 5. Para que el contador sea correcto, el método que incrementa numVecesAlimentado
 *    debe estar sincronizado (synchronized) para evitar race conditions.
 */