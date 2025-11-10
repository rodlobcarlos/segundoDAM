package hilos;

public class GestionaRunnable {

	public static void main(String[] args) {

		HiloRunnable hilo1 = new HiloRunnable("Hilo 1");
		
		HiloRunnable hilo2 = new HiloRunnable("Hilo 2");
		System.out.println("Hilo principal terminado");
		
	}

}
