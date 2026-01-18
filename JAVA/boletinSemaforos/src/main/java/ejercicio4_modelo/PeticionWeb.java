package ejercicio4_modelo;

import java.util.concurrent.Semaphore;

public class PeticionWeb implements Runnable {

	private Semaphore realizaRequest;

	public Semaphore getRealizaRequest() {
		return realizaRequest;
	}

	public void setRealizaRequest(Semaphore realizaRequest) {
		this.realizaRequest = realizaRequest;
	}

	@Override
	public String toString() {
		return "PeticionWeb [realizaRequest=" + realizaRequest + "]";
	}

	public PeticionWeb(Semaphore realizaRequest) {
		super();
		this.realizaRequest = realizaRequest;
	}

	@Override
	public void run() {
		try {
			// Toma un permiso
			realizaRequest.acquire();
			System.out.println("Realizando petición web..." + Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// Suelta un permiso
			realizaRequest.release();
			System.out.println("Liberando petición web..." + Thread.currentThread().getName());
		}
	}

}
