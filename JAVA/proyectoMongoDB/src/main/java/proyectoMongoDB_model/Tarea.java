package proyectoMongoDB_model;

import java.util.Objects;

public class Tarea {

	private String id_tarea;
	private String titulo;
	private String descripcion;
	private Estado estado;
	private int prioridad;
	
	public String getId_tarea() {
		return id_tarea;
	}
	public void setId_tarea(String id_tarea) {
		this.id_tarea = id_tarea;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public Tarea(String id_tarea, String titulo, String descripcion, Estado estado, int prioridad) {
		super();
		this.id_tarea = id_tarea;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.prioridad = prioridad;
	}
	@Override
	public String toString() {
		return "Tarea [id_tarea=" + id_tarea + ", titulo=" + titulo + ", descripcion=" + descripcion + ", estado="
				+ estado + ", prioridad=" + prioridad + "]";
	}
	public Tarea() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, estado, id_tarea, prioridad, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		return Objects.equals(descripcion, other.descripcion) && estado == other.estado
				&& Objects.equals(id_tarea, other.id_tarea) && prioridad == other.prioridad
				&& Objects.equals(titulo, other.titulo);
	}
	
}
