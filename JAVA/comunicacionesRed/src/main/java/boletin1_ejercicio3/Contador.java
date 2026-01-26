package boletin1_ejercicio3;

public class Contador {

	private int numero_total_conexiones;

	public int getNumero_total_conexiones() {
		return numero_total_conexiones;
	}

	public void setNumero_total_conexiones(int numero_total_conexiones) {
		this.numero_total_conexiones = numero_total_conexiones;
	}

	@Override
	public String toString() {
		return "Contador [numero_total_conexiones=" + numero_total_conexiones + "]";
	}

	public Contador() {
		super();
		this.numero_total_conexiones = 1;
	}

	public int conexionesTotales() {
		return numero_total_conexiones ++;

	}
}
