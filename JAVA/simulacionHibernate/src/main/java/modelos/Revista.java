package modelos;

import java.time.LocalDate;
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
@Table(name = "revista")
public class Revista {

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRevista;

	@Column(name = "unidadesImpresas")
	private int unidadesImpresas;

	@Column(name = "numeroRevista")
	private int numeroRevista;

	@OneToMany(mappedBy = "revista", cascade = CascadeType.ALL)
	private List<Articulo> articulos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(int idRevista) {
		this.idRevista = idRevista;
	}

	public int getUnidadesImpresas() {
		return unidadesImpresas;
	}

	public void setUnidadesImpresas(int unidadesImpresas) {
		this.unidadesImpresas = unidadesImpresas;
	}

	public int getNumeroRevista() {
		return numeroRevista;
	}

	public void setNumeroRevista(int numeroRevista) {
		this.numeroRevista = numeroRevista;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	@Override
	public String toString() {
		return "Revista [nombre=" + nombre + ", fecha=" + fecha + ", idRevista=" + idRevista + ", unidadesImpresas="
				+ unidadesImpresas + ", numeroRevista=" + numeroRevista + "]";
	}

	public Revista(String nombre, LocalDate fecha, int unidadesImpresas, int numeroRevista) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.unidadesImpresas = unidadesImpresas;
		this.numeroRevista = numeroRevista;
		this.articulos = new ArrayList<Articulo>();
	}

	public Revista() {
		super();
	}

	public void addArticulo(Articulo articulo) {
		if(!articulos.contains(articulo)) {
			articulos.add(articulo);
		}
	}
}
