package simulacionBancoAlimentos_model;

// --- Clase ---
public class Trabajadores {

	// --- Atributos --- 
	private String nombre;
	private String DNI;
	private String fecha_nacimiento;
	private Personal tipo;
	private String idCentro;

	// --- Getters y setters ---
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Personal getTipo() {
		return tipo;
	}

	public void setTipo(Personal tipo) {
		this.tipo = tipo;
	}

	public String getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(String idCentro) {
		this.idCentro = idCentro;
	}

	// --- toString ---
	@Override
	public String toString() {
		return "Trabajadores [nombre=" + nombre + ", DNI=" + DNI + ", fecha_nacimiento=" + fecha_nacimiento + ", tipo="
				+ tipo + ", idCentro=" + idCentro + "]";
	}

	// --- Constructor ---
	public Trabajadores(String nombre, String dNI, String fecha_nacimiento, Personal tipo, String idCentro) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.fecha_nacimiento = fecha_nacimiento;
		this.tipo = tipo;
		this.idCentro = idCentro;
	}

	// --- Constructor vacío ---
	public Trabajadores() {
		super();
	}

}
