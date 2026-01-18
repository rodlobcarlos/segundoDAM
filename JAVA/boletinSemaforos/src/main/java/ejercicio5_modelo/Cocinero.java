package ejercicio5_modelo;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {

	private Semaphore plato;

	public Semaphore getPlato() {
		return plato;
	}

	public void setPlato(Semaphore plato) {
		this.plato = plato;
	}

	@Override
	public String toString() {
		return "Cocinero [plato=" + plato + "]";
	}

	public Cocinero(Semaphore plato) {
		super();
		this.plato = plato;
	}

	@Override
	public void run() {
		try {
			System.out.println("Estoy cocinando...");
			Thread.sleep(3000);
			plato.release();
			System.out.println("Termine de cocinar... Aquí teneis.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}

}
