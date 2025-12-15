package boletin1Hilos;

public class GestionaTransform {

	public static void main(String[] args) {
		ServiceHilo runnable1 = new ServiceHilo();
		ProcessHilo hilo2 = new ProcessHilo();
		Thread hilo1 = new Thread(runnable1);
		hilo1.start();
		hilo2.start();

		/**
		 * No se observa la misma salida en todas las ejecuciones
		 */
	}
}