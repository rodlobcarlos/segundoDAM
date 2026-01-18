package ejercicio2_controlador;

import ejercicio1_modelo.Proceso;
import ejercicio1_modelo.Servicio;

public class Gestiona_ServiciosProcesos {

	public static void main(String[] args) {

		Proceso hilo1 = new Proceso();
		Servicio hilo2 = new Servicio();
		
		// No se muestra de forma ordenada
		hilo1.start();
		hilo2.start();
		
		System.out.println("Fin del programa.");
	}

}
