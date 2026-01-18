package ejercicio3_controlador;

import java.util.ArrayList;
import java.util.List;

import ejercicio3_modelo.Cuenta;
import ejercicio3_modelo.Hilo1;
import ejercicio3_modelo.Hilo2;

public class Gestiona_cuenta {

	public static void main(String[] args) {

		List<Thread> lista = new ArrayList<Thread>();
		Cuenta cuenta = new Cuenta(500);
		Hilo1 ingresos = new Hilo1(cuenta);
		Hilo2 retiradas = new Hilo2(cuenta);

		Thread hilo1 = new Thread(ingresos);
		Thread hilo2 = new Thread(retiradas);

		lista.add(hilo1);
		lista.add(hilo2);
		hilo1.start();
		hilo2.start();

		for (Thread thread : lista) {
			try {
				hilo1.join();
				hilo2.join();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Saldo actual = " + cuenta.getSaldo());

	}

}
