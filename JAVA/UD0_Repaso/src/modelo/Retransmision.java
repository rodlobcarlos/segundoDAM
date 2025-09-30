package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Retransmision {

	private int id_retransmision;
	private String titulo;
	private LocalDate fecha_inicio;
	private String duracion;
	
	public int getId_retransmision() {
		return id_retransmision;
	}
	public void setId_retransmision(int id_retransmision) {
		this.id_retransmision = id_retransmision;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public Retransmision(int id_retransmision, String titulo, LocalDate fecha_inicio, String duracion) {
		super();
		this.id_retransmision = id_retransmision;
		this.titulo = titulo;
		this.fecha_inicio = fecha_inicio;
		this.duracion = duracion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_retransmision);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retransmision other = (Retransmision) obj;
		return id_retransmision == other.id_retransmision;
	}
	@Override
	public String toString() {
		return "Retransmision [id_retransmision=" + id_retransmision + ", titulo=" + titulo + ", fecha_inicio="
				+ fecha_inicio + ", duracion=" + duracion + "]";
	}
	
	

}
