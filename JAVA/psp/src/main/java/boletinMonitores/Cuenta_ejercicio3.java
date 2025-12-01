package boletinMonitores;


public class Cuenta_ejercicio3 {

	private int saldo;

	public Cuenta_ejercicio3(int saldo) {
		super();
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta_ejercicio3 [saldo=" + saldo + "]";
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	synchronized int retirarDinero() {
		int aleatorio = ((int) (Math.random() * 500 + 1));
		if (aleatorio > saldo) {
			System.out.println("No se puede retirar más dinero del que tienes.");
		} else {
			this.saldo = this.saldo - aleatorio;
			System.out.println("Retirando..." + aleatorio + " Total ->" + this.saldo);
		}
		return this.saldo;
	}

	synchronized int ingresarDinero() {
		int aleatorio = ((int) (Math.random() * 500 + 1));
		this.saldo = this.saldo + aleatorio;
		System.out.println("Ingresando..." + aleatorio + " Total ->" + this.saldo);
		return this.saldo;
	}

}
