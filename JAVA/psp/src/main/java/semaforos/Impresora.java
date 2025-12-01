package semaforos;

public class Impresora {

	public void imprime(String nombreHilo) {
		System.out.println(nombreHilo + " está imprimiendo.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombreHilo + " ha terminado de imprimir.");
	}
}
