package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import model.Desarrollador;
import model.EntornoCloud;
import model.Tipo;

public class GestionaSesionesCloud {

	public static void main(String[] args) {
		Semaphore fila1Desarrolladores = new Semaphore(35);
		Semaphore fila2Desarrolladores = new Semaphore(15);

		List<Thread> hilos = new ArrayList<Thread>();
		EntornoCloud cloud1 = new EntornoCloud(20, Tipo.EDF, fila1Desarrolladores, LocalDate.now(), LocalTime.now());
		EntornoCloud cloud2 = new EntornoCloud(8, Tipo.EPP, fila2Desarrolladores, LocalDate.now(), LocalTime.now());

		Thread hiloCloud1 = new Thread(cloud1);
		Thread hiloCloud2 = new Thread(cloud2);
		hilos.add(hiloCloud1);
		hilos.add(hiloCloud2);

		for (int i = 0; i <= 35; i++) {
			Desarrollador desarrollador1 = new Desarrollador("Desarrollador1 " + i, fila1Desarrolladores);
			Thread hiloDesarrollador1 = new Thread(desarrollador1);
			hiloDesarrollador1.start();
			hilos.add(hiloDesarrollador1);
		}

		cloud1.sesionTipo();

		for (int i = 0; i <= 15; i++) {
			Desarrollador desarrollador2 = new Desarrollador("Desarrollador2 " + i, fila2Desarrolladores);
			Thread hiloDesarrollador2 = new Thread(desarrollador2);
			hiloDesarrollador2.start();
			hilos.add(hiloDesarrollador2);
		}

		for (Thread thread : hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		cloud2.sesionTipo();
	}

}
