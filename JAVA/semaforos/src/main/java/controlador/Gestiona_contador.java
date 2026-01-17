package controlador;

import hilos.Contador;
import hilos.TareaIncremento;

public class Gestiona_contador {

	public static void main(String[] args) throws InterruptedException {

		Contador contador = new Contador();

		// Cada hilo llega a mil 
		Thread hilo1 = new Thread(new TareaIncremento(contador)); 
		Thread hilo2 = new Thread(new TareaIncremento(contador));

		// join(): no se ejecuta otro hilo hasta que el actual termine
		hilo1.start();
		hilo2.start();
		hilo1.join(); 
		hilo2.join();

		System.out.println("Valor final: " + contador.getValor());
	} 

}
