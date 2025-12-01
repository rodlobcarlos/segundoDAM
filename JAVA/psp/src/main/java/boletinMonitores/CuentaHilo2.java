package boletinMonitores;

public class CuentaHilo2 extends Thread{

	private Cuenta_ejercicio3 cuenta;
	
	@Override
	public String toString() {
		return "CuentaHilo1 [cuenta=" + cuenta + "]";
	}

	public CuentaHilo2(Cuenta_ejercicio3 cuenta) {
		super();
		this.cuenta = cuenta;
	}

	public Cuenta_ejercicio3 getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta_ejercicio3 cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public void run() {
		try {
			sleep(1000);
			cuenta.retirarDinero();
			cuenta.retirarDinero();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
