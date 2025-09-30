package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Canal {

	private int id_canal;
	private String titulo;
	private LocalDate fecha_creacion;
	
	public int getId_canal() {
		return id_canal;
	}
	public void setId_canal(int id_canal) {
		this.id_canal = id_canal;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Canal(int id_canal, String titulo, LocalDate fecha_creacion) {
		super();
		this.id_canal = id_canal;
		this.titulo = titulo;
		this.fecha_creacion = fecha_creacion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_canal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Canal other = (Canal) obj;
		return id_canal == other.id_canal;
	}
	@Override
	public String toString() {
		return "Canal [id_canal=" + id_canal + ", titulo=" + titulo + ", fecha_creacion=" + fecha_creacion + "]";
	}
	
	
	

}
