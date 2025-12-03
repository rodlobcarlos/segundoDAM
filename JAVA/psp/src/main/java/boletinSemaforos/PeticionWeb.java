package boletinSemaforos;

import java.util.concurrent.Semaphore;

public class PeticionWeb implements Runnable {

	public PeticionWeb(String nombre, Semaphore semaforo) {
		super();
		this.nombre = nombre;
		this.semaforo = semaforo;
	}

	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	private Semaphore semaforo;

	@Override
	public String toString() {
		return "PeticionWeb [nombre=" + nombre + ", semaforo=" + semaforo + "]";
	}

	@Override
	public void run() {
		turnos();
	}

	public synchronized void turnos() {
		try {
			semaforo.acquire();
			System.out.println("petición adquirida ->" + getNombre());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			System.out.println("petición liberada ->" + getNombre());
		}
	}
}
