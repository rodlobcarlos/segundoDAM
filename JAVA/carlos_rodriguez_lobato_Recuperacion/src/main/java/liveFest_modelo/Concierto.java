package liveFest_modelo;

// --- Clase ---
public class Concierto {

	// --- Atributos ---
	private int id;
	private String fecha;
	private String descripcion;
	private Escenario escenario;
	private Grupo grupo;

	// --- Getters y setters ---
	public int getId() {
		return id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	// --- toString ---
	@Override
	public String toString() {
		return "Concierto [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", escenario=" + escenario
				+ ", grupo=" + grupo + "]";
	}

	// --- Constructor ---
	public Concierto(int id, String fecha, String descripcion, Escenario escenario, Grupo grupo) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.escenario = escenario;
		this.grupo = grupo;
	}

	public Concierto() {
		super();
	}

	
}
