package repasoRed_Ejercicio3;

public class Contador {

	private int contador;

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public String toString() {
		return "Contador [contador=" + contador + "]";
	}

	public Contador() {
		super();
		this.contador = 1;
	}
	
	public int conexiones() {
		return this.contador += 1;
	}
}
