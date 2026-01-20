package hibernate_model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSala;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "capacidad")
	private int capacidad;
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	   private List<Reunion> reuniones;


	public Sala(String nombre) {
		super();
		this.nombre = nombre;
		this.capacidad = 5;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nombre=" + nombre + ", capacidad=" + capacidad + ", reuniones=" + reuniones
				+ "]";
	}

	public Sala() {
		super();
	}

}
