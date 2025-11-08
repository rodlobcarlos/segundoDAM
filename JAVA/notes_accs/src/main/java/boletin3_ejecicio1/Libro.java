package boletin3_ejecicio1;

public class Libro extends Autor {

	private String isbn;
	private String titulo;
	private String nombre;
	private String nombreEditorial;

	public Libro(String nombreAutor, String apellidos, String isbn, String titulo, String nombre,
			String nombreEditorial) {
		super(nombreAutor, apellidos);
		this.isbn = isbn;
		this.titulo = titulo;
		this.nombre = nombre;
		this.nombreEditorial = nombreEditorial;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", nombre=" + nombre + ", nombreEditorial="
				+ nombreEditorial + "]";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreEditorial() {
		return nombreEditorial;
	}

	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}

}
