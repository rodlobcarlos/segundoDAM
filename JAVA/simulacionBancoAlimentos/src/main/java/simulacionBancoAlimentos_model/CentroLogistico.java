package simulacionBancoAlimentos_model;

// --- Imports ---
import java.util.List;

// --- Clase ---
public class CentroLogistico {

	// --- Atributos ---
	private String id;
	private String nombre;
	private String ciudad;
	private int comedores_abastecidos;
	private List<Trabajadores> listaTrabajadores;

	// --- Gettes y setters ---
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getComedores_abastecidos() {
		return comedores_abastecidos;
	}

	public void setComedores_abastecidos(int comedores_abastecidos) {
		this.comedores_abastecidos = comedores_abastecidos;
	}

	public List<Trabajadores> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(List<Trabajadores> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

	// --- toString ---
	@Override
	public String toString() {
		return "CentroLogistico [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", comedores_abastecidos="
				+ comedores_abastecidos + ", listaTrabajadores=" + listaTrabajadores + "]";
	}

	// --- Contructor --- 
	public CentroLogistico(String id, String nombre, String ciudad, int comedores_abastecidos,
			List<Trabajadores> listaTrabajadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.comedores_abastecidos = comedores_abastecidos;
		this.listaTrabajadores = listaTrabajadores;
	}

	// --- Constructor vacío ---
	public CentroLogistico() {
		super();
	}

}
