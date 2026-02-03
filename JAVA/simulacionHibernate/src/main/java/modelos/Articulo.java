package modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulo")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idArticulo")
	private int idArticulo;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "numPaginaInicio")
	private int numPaginaInicio;

	@Column(name = "numPagninaFin")
	private int numPagninaFin;

	@ManyToOne(optional = true)
	private Revista revista;

	@OneToMany(mappedBy = "articulos", cascade = CascadeType.ALL)
	private List<Autor> autores;

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumPaginaInicio() {
		return numPaginaInicio;
	}

	public void setNumPaginaInicio(int numPaginaInicio) {
		this.numPaginaInicio = numPaginaInicio;
	}

	public int getNumPagninaFin() {
		return numPagninaFin;
	}

	public void setNumPagninaFin(int numPagninaFin) {
		this.numPagninaFin = numPagninaFin;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", titulo=" + titulo + ", numPaginaInicio=" + numPaginaInicio
				+ ", numPagninaFin=" + numPagninaFin + ", revista=" + revista + ", autores=" + autores + "]";
	}

	public Articulo(String titulo, int numPaginaInicio, int numPagninaFin) {
		super();
		this.titulo = titulo;
		this.numPaginaInicio = numPaginaInicio;
		this.numPagninaFin = numPagninaFin;
	}

	public Articulo() {
		super();
	}

	public void addAutor(Autor autor) {
		if (!autores.contains(autor)) {
			autores.add(autor);
		}
	}

}
