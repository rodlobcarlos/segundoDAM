package ejercicio4_modelo;

public class Mascota implements Runnable {

	// --- Atributos ---
	private String nombre;
	private int alimentado;

	// --- Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAlimentado() {
		return alimentado;
	}

	public void setAlimentado(int alimentado) {
		this.alimentado = alimentado;
	}

	// --- toString ---
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", alimentado=" + alimentado + "]";
	}

	// --- Constructor ---
	public Mascota(String nombre, int alimentado) {
		super();
		this.nombre = nombre;
		this.alimentado = alimentado;
	}

	// --- Método run() ---
	@Override
	public void run() {
		comer();
	}
	
	// --- Método que controla las veces que come la macota ---
	public void comer() {
		this.alimentado += 1;
		// Pinta el nombre de la mascota y del cuidador
		System.out.println("La macota " + getNombre() + " ha comenzado a comer." + Thread.currentThread().getName());
		try {
			Thread.sleep(1000*this.alimentado);
			// Pinta el nombre de la mascota y del cuidador
			System.out.println("La mascota " + getNombre() + " ha terminado de comer."  + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
