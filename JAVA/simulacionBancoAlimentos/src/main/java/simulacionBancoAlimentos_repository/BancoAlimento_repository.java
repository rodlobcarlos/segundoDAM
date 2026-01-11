package simulacionBancoAlimentos_repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simulacionBancoAlimentos_model.BancoException;
import simulacionBancoAlimentos_model.CentroLogistico;
import simulacionBancoAlimentos_model.Trabajadores;

public class BancoAlimento_repository {

	private static final Logger logger = LogManager.getLogger(BancoAlimento_repository.class);
	private List<CentroLogistico> centroLogisticos;
	private List<Trabajadores> trabajadores;

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

	@Override
	public String toString() {
		return "BancoAlimento_repository [centroLogisticos=" + centroLogisticos + ", trabajadores=" + trabajadores
				+ "]";
	}

	public BancoAlimento_repository() {
		super();
		this.centroLogisticos = new ArrayList<CentroLogistico>();
		this.trabajadores = new ArrayList<Trabajadores>();
	}

	public void añadirCentro(CentroLogistico centroLogistico) throws BancoException {
		if (centroLogisticos.contains(centroLogistico.getId())) {
			throw new BancoException("Ese id ya existe en el centro logístico.");
		}
		centroLogisticos.add(centroLogistico);
	}

	public void añadirTrabajadorACentro(CentroLogistico centroLogistico, Trabajadores trabajadores)
			throws BancoException {
		if (centroLogistico.getListaTrabajadores().contains(trabajadores)) {
			throw new BancoException("Ese trabajador ya existe en el centro logístico.");
		}
		centroLogistico.getListaTrabajadores().add(trabajadores);
	}

	public CentroLogistico leerCentro(String id) throws BancoException {
		CentroLogistico centro1 = null;
		boolean encontrado = false;
		Iterator<CentroLogistico> c = centroLogisticos.iterator();
		while (!encontrado && c.hasNext()) {
			CentroLogistico centro2 = c.next();
			if (centro2.getId().equals(id)) {
				centro1 = centro2;
				encontrado = true;
			} else {
				throw new BancoException("Este centro ya existe.");
			}
		}
		return centro1;
	}
	
	public Trabajadores leerTrabajador(String dni) throws BancoException {
		Trabajadores trabajador1 = null;
		boolean encontrado = false;
		Iterator<Trabajadores> t = trabajadores.iterator();
		while (!encontrado && t.hasNext()) {
			Trabajadores trabajador2 = t.next();
			if (trabajador2.getDNI().equals(dni)) {
				trabajador1 = trabajador2;
				encontrado = true;
			} else {
				throw new BancoException("Este trabajador ya existe.");
			}
		}
		return trabajador1;
	}
}
