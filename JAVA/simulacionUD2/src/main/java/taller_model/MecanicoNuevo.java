package taller_model;

import java.util.concurrent.Semaphore;

public class MecanicoNuevo implements Runnable{
	private String nombre;
	private Semaphore reparar;
	private int tiempoPorCoche;
	private int tiempoAcumulado; 
	private int cochesA_Reparar; 

	public MecanicoNuevo(String nombre, Semaphore reparar, int tiempo, int totalCoches) {
		super();
		this.nombre = nombre;
		this.reparar = reparar;
		this.tiempoPorCoche = tiempo;
		this.cochesA_Reparar = totalCoches;
		this.tiempoAcumulado = 0;
	}
	

	public int getTiempoTotal() {
		return tiempoAcumulado;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void run() {
		int cochesLlevo = 0;

		while (cochesLlevo < cochesA_Reparar) {
			try {
				reparar.acquire(); 
				System.out.println("Estoy reparando un coche -> " + getNombre());

				Thread.sleep(tiempoPorCoche * 1000);

				System.out.println("He reparado un coche -> " + getNombre());

				sumarTiempo2(); 
				cochesLlevo++;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int sumarTiempo2() {
		return this.tiempoAcumulado += tiempoPorCoche;
	}
}
