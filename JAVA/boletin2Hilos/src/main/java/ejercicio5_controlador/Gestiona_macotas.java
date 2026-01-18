package ejercicio5_controlador;

import java.util.ArrayList;

import java.util.List;

import ejercicio5_modelo.Mascota;

public class Gestiona_macotas {

	public static void main(String[] args) {

		/**
		 * Crea el objeto mascota con el numero de veces que come + el número de
		 * cuidadores que le dan de comer adicionalmente.
		 */
		Mascota mascota = new Mascota("Lulú", 10);

		// Lista para guadar los hilos de los cuidadores (5)
		List<Thread> list = new ArrayList<Thread>();

		/**
		 * Bucle de 5 iteraciones, por cada iteración creo un hilo (cuidador) asociado a
		 * la mascota y lo añado a la lista. Además inicio el hilo
		 */
		for (int i = 1; i <= 10; i++) {
			Thread cuidador = new Thread(mascota, " Cuidador " + i);
			list.add(cuidador);
			
			if(i %2 == 0) {
				cuidador.setPriority(cuidador.MAX_PRIORITY);
				}else {
					cuidador.setPriority(cuidador.MIN_PRIORITY);
			}
			
			/** 
			 * Este setPriority sobreescribe los de antes,
			 * asignando de mayor a menor la prioridad 
			 */
			cuidador.setPriority(11 - i);
			cuidador.start();
		}

		/**
		 * Recorro la lista de hilos. Uso join para bloquear la ejecucion hasta que el
		 * hilo termine.
		 */
		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Número de veces final que come la mascota
		System.out.println("Veces que ha comido = " + mascota.getAlimentado());
	}

}
