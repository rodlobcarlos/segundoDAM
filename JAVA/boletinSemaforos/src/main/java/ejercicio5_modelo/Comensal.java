package ejercicio5_modelo;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable {

	private Semaphore comer;

	public Semaphore getComer() {
		return comer;
	}

	public void setComer(Semaphore comer) {
		this.comer = comer;
	}

	@Override
	public String toString() {
		return "Comensal [comer=" + comer + "]";
	}

	public Comensal(Semaphore comer) {
		super();
		this.comer = comer;
	}

	@Override
	public void run() {
		try {
			System.out.println("Estoy esperando para comer..." + Thread.currentThread().getName());
			comer.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			comer.release();
			System.out.println("Ya estoy comiendo" + Thread.currentThread().getName());
		}
	}

}
