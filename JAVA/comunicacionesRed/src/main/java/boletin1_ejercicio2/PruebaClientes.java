package boletin1_ejercicio2;

public class PruebaClientes {

	public static void main(String[] args) {

		for(int i = 0; i < 3; i++) {
			ClienteHilo clienteHilo = new ClienteHilo();
			clienteHilo.start();
		}
	}

}
