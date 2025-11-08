package boletin3_ejecicio1;

public abstract class Autor {

	private String nombreAutor;
	private String apellidos;
	
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@Override
	public String toString() {
		return "Autor [nombre=" + nombreAutor + ", apellidos=" + apellidos + "]";
	}
	public Autor(String nombreAutor, String apellidos) {
		super();
		this.nombreAutor = nombreAutor;
		this.apellidos = apellidos;
	}
}
