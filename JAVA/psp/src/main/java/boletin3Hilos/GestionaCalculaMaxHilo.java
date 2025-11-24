package boletin3Hilos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestionaCalculaMaxHilo {

	public static void main(String[] args) {
		int tamTabla = 10000000;
		int numHilos = 10;
		long t_comienzo = System.currentTimeMillis();

		GestionaCalculaMaxHilo calcula = new GestionaCalculaMaxHilo();

		int[] tabla = calcula.construyeTablaNotas(tamTabla);
		List<Thread> hilos = new ArrayList<Thread>();

		List<CalculaMaxHilo> objetosHilos = new ArrayList<CalculaMaxHilo>();
		try {
			int rango = tamTabla / numHilos;
			for (int i = 0; i < numHilos; i++) {
				CalculaMaxHilo c = new CalculaMaxHilo();
				c.setTabla(tabla);
				c.setInicio(i * rango);
				c.setFin(c.getInicio() + rango - 1);
				objetosHilos.add(c);
				Thread hilo = new Thread(c);
				hilos.add(hilo);
			}
			for (Thread h : hilos) {
				h.start();
			}

			for (Thread h : hilos) {
				h.join();
			}

			// TODO Calcula el maximoTotal a partir objetosHilos Itero la lista de objetos y
			// me quedo con el máximo del atributo maximoTramo

			long t_fin = System.currentTimeMillis();
			long tiempototal = t_fin - t_comienzo;
			System.out.println("El proceso total ha tardado= " + tiempototal + "mseg");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	int[] construyeTablaNotas(int tamanyo) {
		int[] tabla = new int[tamanyo];
		Random r = new Random();
		for (int i = 0; i < tabla.length; i++) {
			try {
				int aleatorio = r.nextInt(5000) + 1;
				tabla[i] = aleatorio;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tabla;
	}
}

class CalculaMaxHilo implements Runnable {
	private int[] tabla;
	private int inicio;
	private int fin;
	private int maximoTramo;

	private int calculaMax() {
		int maxTotal = tabla[inicio];
		for (int i = inicio; i < fin; i++) {
			if (tabla[i] > maxTotal) {
				maxTotal = tabla[i];
			}
		}
		System.out.println("Maximo del rango " + inicio + " - " + fin + ":" + maxTotal);
		return maxTotal;
	}

	@Override
	public void run() {
		maximoTramo = calculaMax();

	}

	/**
	 * @return the tabla
	 */
	public int[] getTabla() {
		return tabla;
	}

	/**
	 * @param tabla the tabla to set
	 */
	public void setTabla(int[] tabla) {
		this.tabla = tabla;
	}

	/**
	 * @return the inicio
	 */
	public int getInicio() {
		return inicio;
	}

	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fin
	 */
	public int getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(int fin) {
		this.fin = fin;
	}

	/**
	 * @return the maximoTramo
	 */
	public int getMaximoTramo() {
		return maximoTramo;
	}

	/**
	 * @param maximoTramo the maximoTramo to set
	 */
	public void setMaximoTramo(int maximoTramo) {
		this.maximoTramo = maximoTramo;
	}

}
