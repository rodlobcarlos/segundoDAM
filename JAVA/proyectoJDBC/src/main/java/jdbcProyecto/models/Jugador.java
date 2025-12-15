package jdbcProyecto.models;

public class Jugador {

	private int id;
	private String nombre;
	private String email;
	private int puntos_totales;
	
	public Jugador(int id, String nombre, String email, int puntos_totales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.puntos_totales = puntos_totales;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", email=" + email + ", puntos_totales=" + puntos_totales
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPuntos_totales() {
		return puntos_totales;
	}

	public void setPuntos_totales(int puntos_totales) {
		this.puntos_totales = puntos_totales;
	}
}
