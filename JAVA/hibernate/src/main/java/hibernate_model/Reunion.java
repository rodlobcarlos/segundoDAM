package hibernate_model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reunion")
public class Reunion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReunion;
	// Es obligatorio usar la notación @Column(name="nombreCampo")
	// Si las columnas de la tablas se llaman diferentes que los atributos
	// @Column(name="fecha")
	private LocalDateTime fecha;
	// @Column(name="asunto")
	private String asunto;

	@ManyToOne
	@JoinColumn(name = "idSala")
	private Sala sala;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Empleado> empleados;

	// Generamos el constructor sin parámetros y los métodos get/set

	public int getIdReunion() {
		return idReunion;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void setIdReunion(int idReunion) {
		this.idReunion = idReunion;
	}

	@Override
	public String toString() {
		return "Reunion [idReunion=" + idReunion + ", fecha=" + fecha + ", asunto=" + asunto + "]";
	}

	public Reunion(LocalDateTime fecha, String asunto, Sala sala) {
		super();
		this.fecha = fecha;
		this.asunto = asunto;
		this.sala = sala;
		this.empleados = new HashSet<Empleado>();
	}

	public Reunion() {
		super();
	}

	public void addEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
		if (!empleado.getReuniones().contains(this)) {
			empleado.getReuniones().add(this);
		}
	}

	public void removeEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
		if (!empleado.getReuniones().contains(this)) {
			empleado.getReuniones().remove(this);
		}
	}

	public Set<Empleado> getEmpleado() {
		return empleados;
	}

}
