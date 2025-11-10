package boletin1Hilos;

public class PrimerHilo extends Thread{

	@Override
	public void run() {
		while(true) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("SERVICIOS");
		}
	}
}
