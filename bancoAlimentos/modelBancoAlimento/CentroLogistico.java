package modelBancoAlimento;

import java.util.List;
import java.util.Objects;

public class CentroLogistico {

	private String idCentrologistico;
	private String nombre;
	private String cuidad;
	private int numeroComedores;
	private List<Trabajadores> listaTrabajadores;
	
	public String getIdCentrologistico() {
		return idCentrologistico;
	}
	public void setIdCentrologistico(String idCentrologistico) {
		this.idCentrologistico = idCentrologistico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuidad() {
		return cuidad;
	}
	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}
	public int getNumeroComedores() {
		return numeroComedores;
	}
	public void setNumeroComedores(int numeroComedores) {
		this.numeroComedores = numeroComedores;
	}
	public List<Trabajadores> getListaTrabajadores() {
		return listaTrabajadores;
	}
	public void setListaTrabajadores(List<Trabajadores> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}
	@Override
	public String toString() {
		return "CentroLogistico [idCentrologistico=" + idCentrologistico + ", nombre=" + nombre + ", cuidad=" + cuidad
				+ ", numeroComedores=" + numeroComedores + ", listaTrabajadores=" + listaTrabajadores + "]";
	}
	public CentroLogistico() {
		super();
		this.idCentrologistico = idCentrologistico;
		this.nombre = nombre;
		this.cuidad = cuidad;
		this.numeroComedores = numeroComedores;
		this.listaTrabajadores = listaTrabajadores;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cuidad, idCentrologistico, listaTrabajadores, nombre, numeroComedores);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CentroLogistico other = (CentroLogistico) obj;
		return Objects.equals(cuidad, other.cuidad) && Objects.equals(idCentrologistico, other.idCentrologistico)
				&& Objects.equals(listaTrabajadores, other.listaTrabajadores) && Objects.equals(nombre, other.nombre)
				&& numeroComedores == other.numeroComedores;
	}
}
