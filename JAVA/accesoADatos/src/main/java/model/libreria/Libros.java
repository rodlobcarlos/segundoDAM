package model.libreria;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Libros {

	private String ISBN;
	private String titulo;
	private String autor;
	private LocalDate año_publicacion;
	private GeneroLibro genero;
	private String editorial;
	private int ejemplares_disponibles;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getAño_publicacion() {
		return año_publicacion;
	}
	public void setAño_publicacion(LocalDate año_publicacion) {
		this.año_publicacion = año_publicacion;
	}
	public GeneroLibro getGenero() {
		return genero;
	}
	public void setGenero(GeneroLibro genero) {
		this.genero = genero;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getEjemplares_disponibles() {
		return ejemplares_disponibles;
	}
	public void setEjemplares_disponibles(int ejemplares_disponibles) {
		this.ejemplares_disponibles = ejemplares_disponibles;
	}
	public Libros(String ISBN, String titulo, String autor, LocalDate año_publicacion, GeneroLibro genero, String editorial,
			int ejemplares_disponibles) {
		super();
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.año_publicacion = año_publicacion;
		this.genero = genero;
		this.editorial = editorial;
		this.ejemplares_disponibles = ejemplares_disponibles;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libros other = (Libros) obj;
		return ISBN == other.ISBN;
	}
	@Override
	public String toString() {
		return "Libros [id=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", año_publicacion=" + año_publicacion
				+ ", genero=" + genero + ", editorial=" + editorial + ", ejemplares_disponibles="
				+ ejemplares_disponibles + "]";
	}
	
	public int compare(Libros o1, Libros o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
