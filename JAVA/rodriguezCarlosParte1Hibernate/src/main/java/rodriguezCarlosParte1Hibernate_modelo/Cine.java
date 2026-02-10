package rodriguezCarlosParte1Hibernate_modelo;

import java.util.ArrayList;
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
@Table(name = "cine")
public class Cine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCine;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "ubicacion")
	private String ubicacion;

	@OneToMany(mappedBy = "cine", cascade = CascadeType.ALL)
	private List<Sala> salas;

	public int getIdCine() {
		return idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public String toString() {
		return "Cine [idCine=" + idCine + ", nombre=" + nombre + ", ubicacion=" + ubicacion + "]";
	}

	public Cine(String nombre, String ubicacion) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.salas = new ArrayList<Sala>();
	}

	public Cine() {
		super();
	}
	
	public void addSala(Sala sala) {
		if(!salas.contains(sala)) {
			salas.add(sala);
		}
	}

}
