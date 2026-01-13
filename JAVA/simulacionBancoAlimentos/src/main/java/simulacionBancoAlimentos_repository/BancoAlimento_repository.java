package simulacionBancoAlimentos_repository;

// --- Imports ---
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simulacionBancoAlimentos_model.BancoException;
import simulacionBancoAlimentos_model.CentroLogistico;
import simulacionBancoAlimentos_model.Trabajadores;

// --- Clase ---
public class BancoAlimento_repository {

	// --- Atributos ---
	private static final Logger logger = LogManager.getLogger(BancoAlimento_repository.class);
	private List<CentroLogistico> centroLogisticos; // Lista centros logísticos.
	private List<Trabajadores> trabajadores; // Lista trabajadores

	// --- Getters y setters --- 
	public List<Trabajadores> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Trabajadores> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public List<CentroLogistico> getCentroLogisticos() {
		return centroLogisticos;
	}

	public void setCentroLogisticos(List<CentroLogistico> centroLogisticos) {
		this.centroLogisticos = centroLogisticos;
	}

	public static Logger getLogger() {
		return logger;
	}

	// --- toString ---
	@Override
	public String toString() {
		return "BancoAlimento_repository [centroLogisticos=" + centroLogisticos + ", trabajadores=" + trabajadores
				+ "]";
	}

	// --- Constructor sin parámetros ---
	public BancoAlimento_repository() {
		super();
		this.centroLogisticos = new ArrayList<CentroLogistico>(); // Inicializa lista centros logísticos (!= null)
		this.trabajadores = new ArrayList<Trabajadores>(); // Inicializa lista trabajadores (!= null)
	}

	// --- Método de añadir centro logístico en la lista creada anteriormente ---
	public void añadirCentro(CentroLogistico centroLogistico) throws BancoException {
		// si centroLogisticos contiene el 'id' del centro pasado por parmetro...
		if (centroLogisticos.contains(centroLogistico.getId())) {
			throw new BancoException("Ese id ya existe en el centro logístico.");
		}
		centroLogisticos.add(centroLogistico); // añade centro a la lista
	}

	// --- Método de añadir trabajador a centro logístico --- 
	public void añadirTrabajadorACentro(CentroLogistico centroLogistico, Trabajadores trabajadores)
			throws BancoException {
		// si la lista de trabajadores del centro pasado por parámetro contiene al trabajador pasado por parámetro...
		if (centroLogistico.getListaTrabajadores().contains(trabajadores)) {
			throw new BancoException("Ese trabajador ya existe en el centro logístico.");
		}
		centroLogistico.getListaTrabajadores().add(trabajadores); // añade trabajador a lista de trabajadores del centro
	}

	// --- Método de leer centro por id---
	public CentroLogistico leerCentro(String id) throws BancoException {
		CentroLogistico centro1 = null; // inicializa centro1 en null
		boolean encontrado = false; // crea booleano en false
		Iterator<CentroLogistico> c = centroLogisticos.iterator(); // intera centros
		// mientras que 'encontrado' = true y haya más elementos en 'c'...
		while (!encontrado && c.hasNext()) {
			// crea objeto centro2 que contiene los 'c' leidos
			CentroLogistico centro2 = c.next();
			if (centro2.getId().equals(id)) {
				centro1 = centro2; // (centro1=null) ahora contiene centro2
				encontrado = true;
			} else {
				throw new BancoException("Este centro ya existe.");
			}
		}
		return centro1; 
	}

	// --- Método de leer trabajador por dni---
	public Trabajadores leerTrabajador(String dni) throws BancoException {
		Trabajadores trabajador1 = null; // inicializa trabajador1 en null
		boolean encontrado = false; // crea booleano en false
		Iterator<Trabajadores> t = trabajadores.iterator(); // intera trabajadores
		// mientras que 'encontrado' = true y haya más elementos en 'c'...
		while (!encontrado && t.hasNext()) {
			// crea objeto trabajador2 que contiene los 'c' leidos
			Trabajadores trabajador2 = t.next();
			if (trabajador2.getDNI().equals(dni)) {
				trabajador1 = trabajador2; // (trabajador1=null) ahora contiene trabajador2
				encontrado = true;
			} else {
				throw new BancoException("Este trabajador ya existe.");
			}
		}
		return trabajador1;
	}
}
