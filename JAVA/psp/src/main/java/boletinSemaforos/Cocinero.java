package boletinSemaforos;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable{

	private String nombre;
	private Semaphore semaforo;
	
	@Override
	public String toString() {
		return "Cocinero [nombre=" + nombre + ", semaforo=" + semaforo + "]";
	}

	public Cocinero(String nombre, Semaphore semaforo) {
		super();
		this.nombre = nombre;
		this.semaforo = semaforo;
	}

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

	@Override
	public void run() {
		while(true) {
//			cocinar();
			menu();
		}
	}
	
	public void cocinar() {
		try {
			Thread.sleep(3000);
			semaforo.release(3);
			System.out.println("Estoy liberado, los comensales pueden comer -> " + getNombre());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void menu() {
		try {
			Thread.sleep(4000);
			semaforo.release(2);
			System.out.println("Estoy liberado, genero menú -> " + getNombre());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
