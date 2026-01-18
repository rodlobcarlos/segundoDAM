package ejercicio1_modelo;

public class Proceso extends Thread {
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				System.out.println("Proceso");
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				// Al dormir, si se interrumpe, salta aquí.
				// Es vital volver a marcar la interrupción o salir del bucle.
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Hilo Proceso finalizado.");
	}

}
