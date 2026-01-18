package ejercicio1_modelo;

public class Proceso extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("Procesos");
			try {
				sleep(500); // Espera 500ms para salir otra vez
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
