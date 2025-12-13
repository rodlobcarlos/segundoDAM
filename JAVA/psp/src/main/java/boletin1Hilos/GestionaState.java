package boletin1Hilos;

import java.util.ArrayList;
import java.util.List;

public class GestionaState {

	public static void main(String[] args) {
		TransformServiceHilo hilo1 = new TransformServiceHilo();
		TransformProcessHilo hilo2 = new TransformProcessHilo();
		Thread h1 = new Thread(hilo1);
		Thread h2 = new Thread(hilo2);

		List<Thread.State> threads = new ArrayList<Thread.State>();
		threads.add(h1.getState());

		h1.start();
		h2.start();

		for (int i = 0; i < threads.size(); i++) {
			try {
				Thread.sleep(500);

				Thread.State estado_h1 = h1.getState();

				if (threads.isEmpty() || !threads.get(threads.size() - 1).equals(estado_h1)) {
					threads.add(estado_h1);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		System.out.println("Estado del hilo proceso: " + threads);

	}
}
