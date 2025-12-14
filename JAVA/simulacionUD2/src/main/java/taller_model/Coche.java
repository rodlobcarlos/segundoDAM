package taller_model;

import java.util.concurrent.Semaphore;

public class Coche implements Runnable{

	private String nombre;
	private Semaphore taller;
	
	public Semaphore getTaller() {
		return taller;
	}

	public void setTaller(Semaphore taller) {
		this.taller = taller;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Coche(String nombre, Semaphore taller) {
		super();
		this.nombre = nombre;
		this.taller = taller;
	}

	@Override
	public String toString() {
		return "Coche [nombre=" + nombre + ", taller=" + taller + "]";
	}

	@Override
	public void run() {
		System.out.println("He llegado al taller -> " + getNombre());
		taller.release();
	}
}
