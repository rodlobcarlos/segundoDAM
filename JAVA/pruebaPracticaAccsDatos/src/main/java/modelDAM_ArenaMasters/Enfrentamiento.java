package modelDAM_ArenaMasters;

import java.util.Objects;

import enumDAM_ArenaMasters.TipoJuego;

public class Enfrentamiento {

	private int id;
	private String fechaEnfrentamiento;
	private String descripcion;
	private TipoJuego videojuego;
	private String equipoGanador;
	
	public Enfrentamiento() {
		super();
		this.id = id;
		this.fechaEnfrentamiento = fechaEnfrentamiento;
		this.descripcion = descripcion;
		this.videojuego = videojuego;
		this.equipoGanador = equipoGanador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFechaEnfrentamiento() {
		return fechaEnfrentamiento;
	}
	public void setFechaEnfrentamiento(String fechaEnfrentamiento) {
		this.fechaEnfrentamiento = fechaEnfrentamiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoJuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(TipoJuego videojuego) {
		this.videojuego = videojuego;
	}
	public String getEquipoGanador() {
		return equipoGanador;
	}
	public void setEquipoGanador(String ganador) {
		this.equipoGanador = ganador;
	}
	@Override
	public String toString() {
		return "Enfrentamiento [id=" + id + ", fechaEnfrentamiento=" + fechaEnfrentamiento + ", descripcion="
				+ descripcion + ", videojuego=" + videojuego + ", equipoGanador=" + equipoGanador + "]";
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
		Enfrentamiento other = (Enfrentamiento) obj;
		return id == other.id;
	}
	
	
}
