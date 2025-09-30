package model.evento;

import java.time.LocalDate;

public class Eventos_deportivos extends Evento{
	
	private double alquilerEstadio;
	private boolean televisivo;

	public Eventos_deportivos(int id, String nombre, LocalDate fecha, int num_entradasVendidas,
			int capacidad_maxima_asistentes, EstadoEven estado, double alquilerEstadio, boolean televisivo) {
		super(id, nombre, fecha, num_entradasVendidas, capacidad_maxima_asistentes, estado);
		this.alquilerEstadio = alquilerEstadio;
		this.televisivo = televisivo;
	}

	public Eventos_deportivos(int id, String nombre, LocalDate fecha, int num_entradasVendidas,
			int capacidad_maxima_asistentes, EstadoEven estado) {
		super(id, nombre, fecha, num_entradasVendidas, capacidad_maxima_asistentes, estado);
		// TODO Auto-generated constructor stub
	}
	
	public double getAlquilerEstadio() {
		return alquilerEstadio;
	}

	public void setAlquilerEstadio(double alquilerEstadio) {
		this.alquilerEstadio = alquilerEstadio;
	}

	public boolean getTelevisivo() {
		return televisivo;
	}

	public void setTelevisivo(boolean televisivo) {
		this.televisivo = televisivo;
	}

	@Override
	public double calcularCosteBase() {
		double costeBase = 0;
		boolean esTelevisado = false;
		if(this.getCapacidad_maxima_asistentes() > 3000) {
			alquilerEstadio = 150000;
			costeBase = alquilerEstadio - 10000;
		} else if(this.getCapacidad_maxima_asistentes() < 3000) {
			alquilerEstadio = 75000;
			costeBase = alquilerEstadio - 10000;
		}else {
			esTelevisado = true;
		}
		return costeBase;
	}
	
}
