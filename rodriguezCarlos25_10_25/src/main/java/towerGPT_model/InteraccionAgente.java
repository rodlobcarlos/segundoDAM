package towerGPT_model;

import java.util.Objects;

public class InteraccionAgente {

	private String id;
	private TipoAgente tipo;
	private String peticion;
	private String respuesta;
	private int timepoEjecucion;
	private double valoracion;
	private double porcentajeAcierto;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TipoAgente getTipo() {
		return tipo;
	}
	public void setTipo(TipoAgente tipo) {
		this.tipo = tipo;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public double getValoracion() {
		return valoracion;
	}
	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
	public double getPorcentajeAcierto() {
		return porcentajeAcierto;
	}
	public void setPorcentajeAcierto(double porcentajeAcierto) {
		this.porcentajeAcierto = porcentajeAcierto;
	}
	public int getTimepoEjecucion() {
		return timepoEjecucion;
	}
	public void setTimepoEjecucion(int timepoEjecucion) {
		this.timepoEjecucion = timepoEjecucion;
	}
	public InteraccionAgente(String id, TipoAgente tipo, String peticion, String respuesta, int timepoEjecucion,
			double valoracion, double porcentajeAcierto) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.peticion = peticion;
		this.respuesta = respuesta;
		this.timepoEjecucion = timepoEjecucion;
		this.valoracion = valoracion;
		this.porcentajeAcierto = porcentajeAcierto;
	}
	@Override
	public String toString() {
		return "InteraccionAgente [id=" + id + ", tipo=" + tipo + ", peticion=" + peticion + ", respuesta=" + respuesta
				+ ", timepoEjecucion=" + timepoEjecucion + ", valoracion=" + valoracion + ", porcentajeAcierto="
				+ porcentajeAcierto + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, peticion, porcentajeAcierto, respuesta, timepoEjecucion, tipo, valoracion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InteraccionAgente other = (InteraccionAgente) obj;
		return Objects.equals(id, other.id) && Objects.equals(peticion, other.peticion)
				&& Double.doubleToLongBits(porcentajeAcierto) == Double.doubleToLongBits(other.porcentajeAcierto)
				&& Objects.equals(respuesta, other.respuesta) && Objects.equals(timepoEjecucion, other.timepoEjecucion)
				&& tipo == other.tipo
				&& Double.doubleToLongBits(valoracion) == Double.doubleToLongBits(other.valoracion);
	}
}
