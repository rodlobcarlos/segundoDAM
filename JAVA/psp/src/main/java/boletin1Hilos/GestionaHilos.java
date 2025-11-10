package boletin1Hilos;

public class GestionaHilos {

	public static void main(String[] args) {

		PrimerHilo runnable1 = new PrimerHilo();
		SegundoHilo hilo2 = new SegundoHilo();
		Thread hilo1 = new Thread(runnable1);
		runnable1.start();
		hilo2.start();
	}

}
