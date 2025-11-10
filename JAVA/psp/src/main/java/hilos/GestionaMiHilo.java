package hilos;

public class GestionaMiHilo {

	public static void main(String[] args) {

		MiHilo hilo1 = new MiHilo("Hilo1");
		System.out.println(hilo1.getState());
		
		MiHilo hilo2 = new MiHilo("Hilo2");

		hilo1.start();
		System.out.println(hilo1.getState());

		hilo2.start();

		System.out.println("En el main");
	}
}
