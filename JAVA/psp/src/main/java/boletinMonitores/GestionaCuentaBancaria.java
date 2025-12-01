package boletinMonitores;

import java.util.ArrayList;
import java.util.List;

public class GestionaCuentaBancaria {

	public static void main(String[] args) {

		List<Thread> hilos = new ArrayList<Thread>();
		Cuenta_ejercicio3 ejercicio3 = new Cuenta_ejercicio3(500);
		CuentaHilo1 hilo1 = new CuentaHilo1(ejercicio3);
		CuentaHilo2 hilo2 = new CuentaHilo2(ejercicio3);
		
		hilos.add(hilo1);
		hilos.add(hilo2);
		
		for(Thread thread: hilos) {
			thread.start();	
		}
		
		for(Thread thread: hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
//		hilo1.start();
//		try {
//			hilo1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		hilo2.start();
//		try {
//			hilo2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("Saldo: " + ejercicio3.getSaldo());
	}
}
