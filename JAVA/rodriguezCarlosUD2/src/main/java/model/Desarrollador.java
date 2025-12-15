package model;

import java.util.concurrent.Semaphore;

public class Desarrollador implements Runnable{

	private String nombre;
	private Semaphore entra;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getEntra() {
		return entra;
	}

	public void setEntra(Semaphore entra) {
		this.entra = entra;
	}

	@Override
	public String toString() {
		return "Desarrollador [nombre=" + nombre + ", entra=" + entra + "]";
	}

	public Desarrollador(String nombre, Semaphore entra) {
		super();
		this.nombre = nombre;
		this.entra = entra;
	}

	@Override
	public void run() {
		System.out.println("Ha llegado el " + nombre);
		entra.release();
	}

}
