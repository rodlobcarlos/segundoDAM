package hilos;

public class HiloRunnable implements Runnable{

	private String nombreHilo;
	
	public String getNombreHilo() {
		return nombreHilo;
	}


	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}


	public HiloRunnable(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}


	@Override
	public String toString() {
		return "HiloRunnable [nombreHilo=" + nombreHilo + "]";
	}


	@Override
	public void run() {
		Thread.currentThread().setName(nombreHilo);
		System.out.println("Ejecutando Hilo:"+Thread.currentThread().getName());	
	}

}
