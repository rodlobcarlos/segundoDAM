package model.ServConversaciones;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

import enu.ServConversaciones.TipoAgente;

public class Conversacion {

	private int id;
	private LocalDate fechaRegistro;
	private Random numAleatorio;
	private TipoAgente agente;
	private String pregunta;
	private String respuesta;
	private int valoracion;
	
	public Conversacion(int id, LocalDate fechaRegistro, Random numAleatorio, TipoAgente agente, String pregunta,
			String respuesta, int valoracion) {
		super();
		this.id = id;
		this.fechaRegistro = fechaRegistro;
		this.numAleatorio = numAleatorio;
		this.agente = agente;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Random getNumAleatorio() {
		return numAleatorio;
	}

	public void setNumAleatorio(Random numAleatorio) {
		this.numAleatorio = numAleatorio;
	}

	public TipoAgente getAgente() {
		return agente;
	}

	public void setAgente(TipoAgente agente) {
		this.agente = agente;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Conversacion [id=" + id + ", fechaRegistro=" + fechaRegistro + ", numAleatorio=" + numAleatorio
				+ ", agente=" + agente + ", pregunta=" + pregunta + ", respuesta=" + respuesta + ", valoracion="
				+ valoracion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agente, fechaRegistro, id, numAleatorio, pregunta, respuesta, valoracion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conversacion other = (Conversacion) obj;
		return agente == other.agente && Objects.equals(fechaRegistro, other.fechaRegistro) && id == other.id
				&& numAleatorio == other.numAleatorio && Objects.equals(pregunta, other.pregunta)
				&& Objects.equals(respuesta, other.respuesta) && valoracion == other.valoracion;
	}
	
}
