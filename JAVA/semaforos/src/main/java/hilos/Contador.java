package hilos;

public class Contador {

	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int incrementar() {
		return valor++;
	}

}