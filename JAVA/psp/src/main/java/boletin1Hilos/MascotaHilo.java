package boletin1Hilos;

/**
 * Clase que representa una mascota que puede ser alimentada por múltiples hilos.
 * Implementa Runnable para permitir la ejecución concurrente.
 */
public class MascotaHilo implements Runnable {

	// Nombre de la mascota
	private String nombre;
	
	// Contador de veces que ha sido alimentada
	private int vecesAlimentado;

	public MascotaHilo(String nombre, int vecesAlimentado) {
		super();
		this.nombre = nombre;
		this.vecesAlimentado = vecesAlimentado;
	}

	@Override
	public String toString() {
		return "MascotaHilo [nombre=" + nombre + ", vecesAlimentado=" + vecesAlimentado + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVecesAlimentado() {
		return vecesAlimentado;
	}

	public void setVecesAlimentado(int vecesAlimentado) {
		this.vecesAlimentado = vecesAlimentado;
	}

	@Override
	public void run() {
		// Incrementar el contador de alimentaciones
		comer();
		
		try {
			// Simular el tiempo que tarda en comer (1 segundo)
			Thread.sleep(1000);
			System.out.println("La mascota " + getNombre() + " ha terminado de comer." + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void comer() {
		// Incrementar el contador 
		this.vecesAlimentado++;
		System.out.println("La mascota " + getNombre() + " ha empezado a comer." + Thread.currentThread().getName());
	}
}