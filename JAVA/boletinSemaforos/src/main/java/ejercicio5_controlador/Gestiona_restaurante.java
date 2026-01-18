package ejercicio5_controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import ejercicio5_modelo.Cocinero;
import ejercicio5_modelo.Comensal;

public class Gestiona_restaurante {

	public static void main(String[] args) {

		Semaphore plato = new Semaphore(0);
		
		List<Thread> list = new ArrayList<Thread>();
		Cocinero cocinero = new Cocinero(plato);
		Comensal comensal = new Comensal(plato);
		
		Thread hiloCocinero = new Thread(cocinero);
		list.add(hiloCocinero);		
		hiloCocinero.start();

		for(int i = 0; i < 3; i++) {
			Thread hiloComensal = new Thread(comensal, " Comensal" + i);
			
			list.add(hiloComensal);
			hiloComensal.start();
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
