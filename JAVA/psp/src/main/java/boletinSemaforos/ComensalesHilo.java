package boletinSemaforos;

import java.util.concurrent.Semaphore;

public class ComensalesHilo implements Runnable{

	private String nombre;
	private Semaphore semaforo;
	
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

	public ComensalesHilo(String nombre, Semaphore semaforo) {
		super();
		this.nombre = nombre;
		this.semaforo = semaforo;
	}

	@Override
	public String toString() {
		return "ComensalesHilo [nombre=" + nombre + ", semaforo=" + semaforo + "]";
	}

	@Override
	public void run() {
		while (true) {
			comer();
		}
	}
	
	public void comer() {
		try {
			semaforo.acquire();
			System.out.println("Estoy comiendo ->" + getNombre());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
