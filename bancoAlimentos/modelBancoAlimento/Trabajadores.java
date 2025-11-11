package modelBancoAlimento;

import java.util.Objects;

public class Trabajadores {

	private String nombre;
	private String dni;
	private String fechaNacimiento;
	private TipoPersonal tipo;
	private String idCentroLogistico;
	
	public Trabajadores() {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.tipo = tipo;
		this.idCentroLogistico = idCentroLogistico;
	}

	@Override
	public String toString() {
		return "Trabajdores [nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", tipo="
				+ tipo + ", idCentroLogistico=" + idCentroLogistico + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TipoPersonal getTipo() {
		return tipo;
	}

	public void setTipo(TipoPersonal tipo) {
		this.tipo = tipo;
	}

	public String getIdCentroLogistico() {
		return idCentroLogistico;
	}

	public void setIdCentroLogistico(String idCentroLogistico) {
		this.idCentroLogistico = idCentroLogistico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, fechaNacimiento, idCentroLogistico, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajadores other = (Trabajadores) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(idCentroLogistico, other.idCentroLogistico) && Objects.equals(nombre, other.nombre)
				&& tipo == other.tipo;
	}
}
