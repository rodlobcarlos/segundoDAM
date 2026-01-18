package ejercicio3_modelo;

public class Cuenta{

	private int saldo;

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}

	public Cuenta(int saldo) {
		super();
		this.saldo = saldo;
	}

	public synchronized void ingresar() {
		int aleatorio = ((int) (Math.random() * 500 + 1));
		this.saldo = this.saldo + aleatorio;
		if(saldo < aleatorio) {
			System.out.println("No se pueden hacer operaciones.");
		}
		System.out.println("Ingresado -> " + aleatorio + " Saldo = " + this.saldo);
	}

	public synchronized void retirar() {
		int aleatorio = ((int) (Math.random() * 500 + 1));
		this.saldo = this.saldo - aleatorio;
		System.out.println("Retirado -> " + aleatorio + " Saldo = " + this.saldo);
	}

}
