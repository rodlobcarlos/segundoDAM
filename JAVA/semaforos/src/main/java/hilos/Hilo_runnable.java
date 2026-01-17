package hilos;

public class Hilo_runnable implements Runnable {

	private String nombre;

	public Hilo_runnable(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(this.nombre); // setea el atributo al nombre del hilo
		System.out.println("Ejecutando Hilo:" + Thread.currentThread().getName()); // coge el nombre seteado antes
	}
}
