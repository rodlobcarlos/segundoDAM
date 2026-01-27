package boletin1_ejercicio5;

import java.util.Random;

public class Numero {
	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Numero [numero=" + numero + "]";
	}

	public Numero() {
		super();
		this.numero = numero;
	}

	public void numeroAleatorio() {
		Random rand = new Random();
		this.numero = rand.nextInt(21);
	}

}
