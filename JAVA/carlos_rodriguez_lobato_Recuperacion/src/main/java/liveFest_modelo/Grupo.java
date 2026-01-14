package liveFest_modelo;

// --- Clase ---
public class Grupo {

	// --- Atributos ---
	private String nombre;
	private String codigo;
	private int numIntegrantes;
	private String email;

	// --- Getters y setters ---
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getNumIntegrantes() {
		return numIntegrantes;
	}

	public void setNumIntegrantes(int numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// --- toString ---
	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", codigo=" + codigo + ", numIntegrantes=" + numIntegrantes + ", email="
				+ email + "]";
	}

	// --- Constructor ---
	public Grupo(String nombre, String codigo, int numIntegrantes, String email) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.numIntegrantes = numIntegrantes;
		this.email = email;
	}

	public Grupo() {
		super();
	}

}
