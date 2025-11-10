package hilos;

public class MiHilo extends Thread{
	
	private String nombreHilo;
	
	@Override
	public String toString() {
		return "MiHilo [nombreHilo=" + nombreHilo + "]";
	}

	public MiHilo(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	@Override
	public void run() {
		System.out.println(this.nombreHilo + "estado: " + this.getState());
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termina:" + this.nombreHilo);
	}
}
