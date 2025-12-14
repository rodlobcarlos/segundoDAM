package taller_model;

import java.util.concurrent.Semaphore;

public class Mecanico implements Runnable {

	private String nombre;
	private Semaphore reparar;
	private int tiempo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getReparar() {
		return reparar;
	}

	public void setReparar(Semaphore reparar) {
		this.reparar = reparar;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Mecanico [nombre=" + nombre + ", reparar=" + reparar + ", tiempo=" + tiempo
				+ "]";
	}

	public Mecanico(String nombre, Semaphore reparar, int tiempo) {
		super();
		this.nombre = nombre;
		this.reparar = reparar;
		this.tiempo = tiempo;
	}

	@Override
	public void run() {
		tiempoTotal();
		try {
			System.out.println("Estoy reparando un coche -> " + getNombre());
			reparar.acquire();
			Thread.sleep(5000);
			System.out.println("He reparado un coche -> " + getNombre());
			reparar.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int tiempoTotal() {
		return this.tiempo += tiempo;
	}
}
