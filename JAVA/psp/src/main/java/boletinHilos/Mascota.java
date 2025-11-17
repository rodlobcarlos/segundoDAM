package boletinHilos;

public class Mascota implements Runnable{

	private String nombre;
	private int numVecesAlimentado;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumVecesAlimentado() {
		return numVecesAlimentado;
	}
	public void setNumVecesAlimentado(int numVecesAlimentado) {
		this.numVecesAlimentado = numVecesAlimentado;
	}
	public Mascota(String nombre) {
		super();
		this.nombre = nombre;
		this.numVecesAlimentado = 0;
	}
	@Override
	public String toString() {
		return "Mascota [nombre=" + this.getNombre() + ", numVecesAlimentado=" + numVecesAlimentado + "]";
	}
	
	@Override
	public void run() {
		int metodo = comer();
		try {
			Thread.sleep(1000);
			System.out.println("La mascota " + this.getNombre() + " ha terminado de comer: " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int comer() {
		this.numVecesAlimentado++;
		System.out.println("La mascota " + this.getNombre() + " ha empezado a comer: " + Thread.currentThread().getName());
		return this.numVecesAlimentado;
	}
}
