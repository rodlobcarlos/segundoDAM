package ejercicio6_modelo;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {

	private Semaphore plato;
	private Semaphore menu;

	public Semaphore getMenu() {
		return menu;
	}

	public void setMenu(Semaphore menu) {
		this.menu = menu;
	}

	public Semaphore getPlato() {
		return plato;
	}

	public void setPlato(Semaphore plato) {
		this.plato = plato;
	}

	@Override
	public String toString() {
		return "Cocinero [plato=" + plato + ", menu=" + menu + "]";
	}

	public Cocinero(Semaphore plato, Semaphore menu) {
		super();
		this.plato = plato;
		this.menu = menu;
	}

	@Override
	public void run() {
		try {
			System.out.println("Estoy cocinando...");
			Thread.sleep(3000);
			System.out.println("Termine de cocinar... Aquí teneis.");
			plato.release(3);
			System.out.println("Aquí tienes el menú.");
			menu.release(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
