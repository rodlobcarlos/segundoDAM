package ejercicio6_modelo;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable {

	private Semaphore comer;
	private Semaphore menu;

	public Semaphore getMenu() {
		return menu;
	}

	public void setMenu(Semaphore menu) {
		this.menu = menu;
	}

	public Semaphore getComer() {
		return comer;
	}

	public void setComer(Semaphore comer) {
		this.comer = comer;
	}

	@Override
	public String toString() {
		return "Comensal [comer=" + comer + ", menu=" + menu + "]";
	}

	public Comensal(Semaphore comer, Semaphore menu) {
		super();
		this.comer = comer;
		this.menu = menu;
	}

	@Override
	public void run() {
		try {
			System.out.println("Estoy esperando el menú..." + Thread.currentThread().getName());
			comer.acquire();
			System.out.println("Tengo el menú." + Thread.currentThread().getName());
			comer.release();
			System.out.println("Ya estoy comiendo" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
