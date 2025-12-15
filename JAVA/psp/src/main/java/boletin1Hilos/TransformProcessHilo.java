package boletin1Hilos;

public class TransformProcessHilo implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500); // Espera 500ms para salir con consola e implementa Threads
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("PROCESOS");
		}
	}
}
