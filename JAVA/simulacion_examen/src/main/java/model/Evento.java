package model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Evento {

	private static int contador;
	private int id;
	private String nombre;
	private LocalDate fecha;
	private int num_entradasVendidas;
	private int capacidad_maxima_asistentes;
	private EstadoEven estado;

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Evento.contador = contador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNum_entradasVendidas() {
		return num_entradasVendidas;
	}

	public void setNum_entradasVendidas(int num_entradasVendidas) {
		this.num_entradasVendidas = num_entradasVendidas;
	}

	public int getCapacidad_maxima_asistentes() {
		return capacidad_maxima_asistentes;
	}

	public void setCapacidad_maxima_asistentes(int capacidad_maxima_asistentes) {
		this.capacidad_maxima_asistentes = capacidad_maxima_asistentes;
	}

	public EstadoEven getEstado() {
		return estado;
	}

	public void setEstado(EstadoEven estado) {
		this.estado = estado;
	}

	public Evento(int id, String nombre, LocalDate fecha, int num_entradasVendidas, int capacidad_maxima_asistentes,
			EstadoEven estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.num_entradasVendidas = num_entradasVendidas;
		this.capacidad_maxima_asistentes = capacidad_maxima_asistentes;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Evento [nombre=" + nombre + ", fecha=" + fecha + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return id == other.id;
	}

	public boolean validarDatos(Evento e) throws CraftterException {
		boolean valido = false;
		if (e.capacidad_maxima_asistentes < 0 || e.num_entradasVendidas < 0) {
			valido = true;
		} else if (e.num_entradasVendidas > e.capacidad_maxima_asistentes) {
			valido = true;
		} else {
			throw new CraftterException("No es posible contruir un evento con esos datos.");
		}
		return valido;

	}
	
	public boolean modificarEstado(EstadoEven nuevo_estado) throws CraftterException {
		boolean esModificado = false;
		if(estado.equals(estado.PENDIENTE) && (nuevo_estado.equals(nuevo_estado.PROGRAMADO)
				|| nuevo_estado.equals(nuevo_estado.CANCELADO) || nuevo_estado.equals(nuevo_estado.FINALIZADO))) {
			this.setEstado(nuevo_estado);
			
		} else if(estado.equals(estado.APLAZADO) && (nuevo_estado.equals(nuevo_estado.PROGRAMADO))) {
			this.setEstado(nuevo_estado);
			
		} else if(estado.equals(estado.PROGRAMADO) && (nuevo_estado.equals(nuevo_estado.CANCELADO) 
				|| nuevo_estado.equals(nuevo_estado.FINALIZADO) || nuevo_estado.equals(nuevo_estado.APLAZADO))) {
			this.setEstado(nuevo_estado);
			
		} else if(estado.equals(estado.CANCELADO) && (nuevo_estado.equals(nuevo_estado.FINALIZADO) 
				|| nuevo_estado.equals(nuevo_estado.APLAZADO))) {
			this.setEstado(nuevo_estado);
			
		} else if(estado.equals(estado.FINALIZADO) && (nuevo_estado.equals(nuevo_estado.APLAZADO))) {
			this.setEstado(nuevo_estado);

		} else {
			throw new CraftterException("No es posible pasar al estado: " + nuevo_estado);
		}
		return esModificado;	
	}
	
	public int getPorcentajeOcupacion() {
		int porcentajeOcupacion = capacidad_maxima_asistentes / num_entradasVendidas;
		return porcentajeOcupacion;
	}
	
	public int getPorcentajeOcupacion(int numeroEntradas) {
		int calculoOcupacion = num_entradasVendidas + numeroEntradas;
		return calculoOcupacion;
		
	}
	
	public abstract double calcularCosteBase();
}
