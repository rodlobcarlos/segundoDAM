package ejercicio2_modelo;

import java.util.concurrent.Semaphore;

public class Coche implements Runnable {

	private Semaphore repostar;

	public Semaphore getRepostar() {
		return repostar;
	}

	public void setRepostar(Semaphore repostar) {
		this.repostar = repostar;
	}

	@Override
	public String toString() {
		return "Coche [repostar=" + repostar + "]";
	}

	public Coche(Semaphore repostar) {
		super();
		this.repostar = repostar;
	}

	@Override
	public void run() {
		try {
			// Toma un permiso
			repostar.acquire();
			System.out.println("Tengo un coche repostando. " + Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Suelta SOLO 1 permiso
			repostar.release();
			System.out.println("Estoy soltando un coche. " + Thread.currentThread().getName());
		}
	}

}
