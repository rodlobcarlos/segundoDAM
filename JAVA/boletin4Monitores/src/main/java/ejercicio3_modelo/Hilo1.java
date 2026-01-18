package ejercicio3_modelo;

public class Hilo1 implements Runnable {

	private Cuenta cuenta;

	public Hilo1(Cuenta cuenta) {
		super();
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			cuenta.ingresar();
			cuenta.ingresar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
