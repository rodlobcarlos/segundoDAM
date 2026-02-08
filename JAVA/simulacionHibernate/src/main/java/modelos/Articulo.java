	package modelos;
	
	import java.util.ArrayList;
	import java.util.List;
	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToMany;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "articulo")
	public class Articulo {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idArticulo;
	
		@Column(name = "titulo")
		private String titulo;
	
		@Column(name = "numPaginaInicio")
		private int numPaginaInicio;
	
		@Column(name = "numPaginaFin")
		private int numPaginaFin;
	
		@ManyToOne(optional = true)
		@JoinColumn(name = "idRevista")
		private Revista revista;
	
		@ManyToMany
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
	
		public int getNumPaginaFin() {
			return numPaginaFin;
		}
	
		public void setNumPaginaFin(int numPaginaFin) {
			this.numPaginaFin = numPaginaFin;
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
					+ ", numPaginaFin=" + numPaginaFin + "]";
		}
	
		public Articulo(String titulo, int numPaginaInicio, int numPaginaFin) {
			super();
			this.titulo = titulo;
			this.numPaginaInicio = numPaginaInicio;
			this.numPaginaFin = numPaginaFin;
			this.autores = new ArrayList<Autor>();
		}
	
		public Articulo() {
			super();
		}
	
		public void addAutor(Autor autor) {
			if(!autores.contains(autor)) {
				autores.add(autor);
			}
		}
	}
