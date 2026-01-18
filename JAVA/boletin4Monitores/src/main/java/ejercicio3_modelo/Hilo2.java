package ejercicio3_modelo;

public class Hilo2 implements Runnable {

	private Cuenta cuenta;

	public Hilo2(Cuenta cuenta) {
		super();
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			cuenta.retirar();
			cuenta.retirar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
