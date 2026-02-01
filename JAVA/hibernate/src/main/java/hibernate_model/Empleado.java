package hibernate_model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "salario")
	private double salario;

	@ManyToMany
	private Set<Reunion> reuniones;

	@ManyToOne
	@JoinColumn(name = "idDepartamento")
	private Departamento departamento;

	public Empleado(String nombre, double salario) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.reuniones = new HashSet<Reunion>();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamentos() {
		return departamento;
	}

	public void setDepartamentos(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<Reunion> getReuniones() {
		return reuniones;
	}

	public void setReuniones(Set<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", salario=" + salario + ", departamento="
				+ departamento + "]";
	}

	public Empleado() {
		super();
	}

	public void addReunion(Reunion reunion) {
		this.reuniones.add(reunion);
		if (!reunion.getEmpleados().contains(this)) {
			reunion.getEmpleados().add(this);
		}
	}

	public void removeReunion(Reunion reunion) {
		this.reuniones.remove(reunion);
		if (!reunion.getEmpleados().contains(this)) {
			reunion.getEmpleados().remove(this);
		}
	}

	public Set<Reunion> getReunion() {
		return reuniones;
	}

}
