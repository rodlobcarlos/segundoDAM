package ejercicio2_modelo;

public class Proceso implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("Procesos");
			try {
				Thread.sleep(500); // Espera 500ms para salir otra vez
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
