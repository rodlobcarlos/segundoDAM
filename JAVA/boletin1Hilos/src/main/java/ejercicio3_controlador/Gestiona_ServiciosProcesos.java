package ejercicio3_controlador;

import java.util.ArrayList;
import java.util.List;

import ejercicio1_modelo.Proceso;
import ejercicio1_modelo.Servicio;

public class Gestiona_ServiciosProcesos {

	public static void main(String[] args) {

		Proceso hilo1 = new Proceso();
		Servicio hilo2 = new Servicio();

		List<Thread.State> estados = new ArrayList<Thread.State>();
		estados.add(hilo1.getState());
		estados.add(hilo2.getState());

		hilo1.start();
		hilo2.start();

		for (Thread.State t : estados) {
			System.out.println("Estado del hilo actual:" + t);
		}

		System.out.println("Fin del programa.");
	}

}
