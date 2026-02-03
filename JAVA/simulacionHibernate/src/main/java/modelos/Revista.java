package modelos;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "revista")
public class Revista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRevista;

	@Column(name = "nombreRevista")
	private String nombreRevista;

	@Column(name = "numeroRevista")
	private int numeroRevista;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "unidadesImpresas")
	private int unidadesImpresas;

	@OneToMany(mappedBy = "revista", cascade = CascadeType.ALL)
	private List<Articulo> articulos;

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public int getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(int idRevista) {
		this.idRevista = idRevista;
	}

	public String getNombreRevista() {
		return nombreRevista;
	}

	public void setNombreRevista(String nombreRevista) {
		this.nombreRevista = nombreRevista;
	}

	public int getNumeroRevista() {
		return numeroRevista;
	}

	public void setNumeroRevista(int numeroRevista) {
		this.numeroRevista = numeroRevista;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getUnidadesImpresas() {
		return unidadesImpresas;
	}

	public void setUnidadesImpresas(int unidadesImpresas) {
		this.unidadesImpresas = unidadesImpresas;
	}

	@Override
	public String toString() {
		return "Revista [idRevista=" + idRevista + ", nombreRevista=" + nombreRevista + ", numeroRevista="
				+ numeroRevista + ", fecha=" + fecha + ", unidadesImpresas=" + unidadesImpresas + ", articulos="
				+ articulos + "]";
	}

	public Revista(String nombreRevista, int numeroRevista, LocalDate fecha, int unidadesImpresas) {
		super();
		this.nombreRevista = nombreRevista;
		this.numeroRevista = numeroRevista;
		this.fecha = fecha;
		this.unidadesImpresas = unidadesImpresas;
	}

	public Revista() {
		super();
	}

	public void addArticulo(Articulo articulo) {
		if (!articulos.contains(articulo)) {
			articulos.add(articulo);
		}
	}
}
