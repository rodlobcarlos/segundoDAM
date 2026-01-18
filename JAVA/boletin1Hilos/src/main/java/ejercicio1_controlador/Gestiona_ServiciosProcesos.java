package ejercicio1_controlador;

import java.util.Scanner;

import ejercicio1_modelo.Proceso;
import ejercicio1_modelo.Servicio;

public class Gestiona_ServiciosProcesos {

	public static void main(String[] args) {

		Proceso hilo1 = new Proceso();
		Servicio hilo2 = new Servicio();
		
		// No se muestra de forma ordenada
		hilo1.start();
		hilo2.start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine(); // Salto de linea (enter)
		
		// Interrumpe el hilo que hemos manejado para que termine
		hilo1.interrupt(); // Hilo interrumpido
		hilo2.interrupt();
		
		System.out.println("Fin del programa.");
	}

}
