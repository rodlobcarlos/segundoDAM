package ejercicio3_modelo;

public class Servicio implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("Servicios");
			try {
				Thread.sleep(1000); // Espera 500ms para salir otra vez
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
