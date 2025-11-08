package boletin3_ejecicio2;

public class Pais {

	private String Nombre;
	private String Continente;
	private int Poblacion;
	private String Idioma;
	private String Moneda;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getContinente() {
		return Continente;
	}
	public void setContinente(String continente) {
		Continente = continente;
	}
	public int getPoblacion() {
		return Poblacion;
	}
	public void setPoblacion(int poblacion) {
		Poblacion = poblacion;
	}
	public String getIdioma() {
		return Idioma;
	}
	public void setIdioma(String idioma) {
		Idioma = idioma;
	}
	public String getMoneda() {
		return Moneda;
	}
	public void setMoneda(String moneda) {
		Moneda = moneda;
	}
	public Pais(String nombre, String continente, int poblacion, String idioma, String moneda) {
		super();
		Nombre = nombre;
		Continente = continente;
		Poblacion = poblacion;
		Idioma = idioma;
		Moneda = moneda;
	}
	@Override
	public String toString() {
		return "Pais [Nombre=" + Nombre + ", Continente=" + Continente + ", Poblacion=" + Poblacion + ", Idioma="
				+ Idioma + ", Moneda=" + Moneda + "]";
	}
	
	
}
