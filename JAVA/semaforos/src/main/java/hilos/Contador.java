package hilos;

public class Contador {

	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	// Se sincroniza para que no haya concurrencia
	public synchronized int incrementar() {
		return valor++;
	}

}