package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.Semaphore;

public class EntornoCloud implements Runnable {

	private int sesiones;
	private Tipo entorno;
	private Semaphore control;
	private LocalDate fecha;
	private LocalTime tiempo;

	public int getSesiones() {
		return sesiones;
	}

	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}

	public Tipo getEntorno() {
		return entorno;
	}

	public void setEntorno(Tipo entorno) {
		this.entorno = entorno;
	}

	public Semaphore getControl() {
		return control;
	}

	public void setControl(Semaphore control) {
		this.control = control;
	}

	@Override
	public String toString() {
		return "EntornoCloud [sesiones=" + sesiones + ", entorno=" + entorno + ", control=" + control + ", fecha="
				+ fecha + ", tiempo=" + tiempo + "]";
	}

	public EntornoCloud(int sesiones, Tipo entorno, Semaphore control, LocalDate fecha, LocalTime tiempo) {
		super();
		this.sesiones = sesiones;
		this.entorno = entorno;
		this.control = control;
		this.fecha = fecha;
		this.tiempo = tiempo;
	}

	@Override
	public void run() {
		sesionTipo();
	}

	public void sesionTipo() {
		for (int i = 0; i <= sesiones; i++) {
			try {
				control.acquire();
				System.out.println("El desarrollador " + i + " ha iniciado sesión en el entorno " + entorno + " el "
						+ fecha + " a las " + tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("El desarrollador " + i + " no ha podido cerrar sesión en el entorno " + entorno
//					+ " :sesiones agotadas");
		}
	}
}
