package model;

import java.time.LocalDate;

public class Eventos_deportivos extends Evento{
	
	private float alquilerEstadio;
	private float televisivo;

	public Eventos_deportivos(int id, String nombre, LocalDate fecha, int num_entradasVendidas,
			int capacidad_maxima_asistentes, EstadoEven estado, float alquilerEstadio, float televisivo) {
		super(id, nombre, fecha, num_entradasVendidas, capacidad_maxima_asistentes, estado);
		this.alquilerEstadio = alquilerEstadio;
		this.televisivo = televisivo;
	}

	public Eventos_deportivos(int id, String nombre, LocalDate fecha, int num_entradasVendidas,
			int capacidad_maxima_asistentes, EstadoEven estado) {
		super(id, nombre, fecha, num_entradasVendidas, capacidad_maxima_asistentes, estado);
		// TODO Auto-generated constructor stub
	}
	
	public float getAlquilerEstadio() {
		return alquilerEstadio;
	}

	public void setAlquilerEstadio(float alquilerEstadio) {
		this.alquilerEstadio = alquilerEstadio;
	}

	public float getTelevisivo() {
		return televisivo;
	}

	public void setTelevisivo(float televisivo) {
		this.televisivo = televisivo;
	}

	@Override
	public double calcularCosteBase() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	public void alquilerEstadio() {
		if(alquilerEstadio ) {
			
		}
		
	}
*/
}
