package boletin1Hilos;

public class ServiceHilo extends Thread{

	@Override
	public void run() {
		while(true) {
			try {
				sleep(500); // Espera 500ms para salir con consola
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("SERVICIOS");
		}
	}
}
