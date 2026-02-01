package boletin1_ejercicio5;

import java.util.Random;

public class Numero {
	private int numero;
	private boolean acertado = false; // Compartido entre hilos

	public Numero() {
		Random rand = new Random();
		this.numero = rand.nextInt(21); // Genera entre 0 y 20
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isAcertado() {
		return acertado;
	}

	public void setAcertado(boolean acertado) {
		this.acertado = acertado;
	}

	@Override
	public String toString() {
		return "Numero [numero=" + numero + ", acertado=" + acertado + "]";
	}

	public Numero(int numero, boolean acertado) {
		super();
		this.numero = numero;
		this.acertado = acertado;
	}

}