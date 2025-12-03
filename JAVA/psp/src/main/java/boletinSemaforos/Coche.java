package boletinSemaforos;

import java.util.concurrent.Semaphore;

public class Coche implements Runnable {

	private String nombre;
	private Semaphore semaforo;

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	public Coche(String nombre, Semaphore semaforo) {
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

	@Override
	public String toString() {
		return "Coche [semaforo=" + semaforo + "]";
	}

	@Override
	public void run() {
		pago();
		turnos();
	}

	public void turnos() {
		try {
			semaforo.acquire();
			System.out.println("surtidor adquirido ->" + getNombre());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			System.out.println("surtidor liberado ->" + getNombre());
		}
	}

	public void pago() {
		System.out.println("Pago con tarjeta.");
	}
}
