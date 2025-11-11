package repositoryBancoAlimentacion;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptionBancoAlimento.BancoException;
import modelBancoAlimento.CentroLogistico;
import modelBancoAlimento.Trabajadores;

public class RepositoryCentroLogistico {
	private static final String rutaResources = "src\\main\\resources\\";
	private static final Logger logger = LogManager.getLogger(RepositoryCentroLogistico.class);

	private List<CentroLogistico> listaCentroLogistico;

	public RepositoryCentroLogistico(List<CentroLogistico> listaCentroLogistico) {
		super();
		this.listaCentroLogistico = listaCentroLogistico;
	}

	@Override
	public String toString() {
		return "RepositoryCentroLogistico [listaCentroLogistico=" + listaCentroLogistico + "]";
	}

	public List<CentroLogistico> getListaCentroLogistico() {
		return listaCentroLogistico;
	}

	public void setListaCentroLogistico(List<CentroLogistico> listaCentroLogistico) {
		this.listaCentroLogistico = listaCentroLogistico;
	}
	
	public void agregarCentroLogistico(CentroLogistico centroLogistico) throws BancoException {
		if(!listaCentroLogistico.contains(centroLogistico.getIdCentrologistico())) {
			listaCentroLogistico.add(centroLogistico);
		}else {
			throw new BancoException("Ese centro logístico con ese id ya existe.");
		}
	}
	
	public void agregarTrabajador(Trabajadores trabajadores) throws BancoException {
		CentroLogistico centro = null;
		List<Trabajadores> centroTrabajadores = centro.getListaTrabajadores();
		for(Trabajadores t: centroTrabajadores) {
			if(!t.getDni().equals(trabajadores.getDni())) {
				centroTrabajadores.add(trabajadores);
			}else {
				throw new BancoException("Ese trabajador ya está asociado.");
			}
		}
	}
	
	public CentroLogistico leerCentroLogistico(String id) throws BancoException {
		CentroLogistico centro1 = null;
		boolean encontrado = false;
		Iterator<CentroLogistico> e = listaCentroLogistico.iterator();
		while (!encontrado && e.hasNext()) {
			CentroLogistico centro2 = e.next();
			if (centro2.getIdCentrologistico().equals(id)) {
				centro1 = centro2;
				encontrado = true;
			} else {
				throw new BancoException("Este centro logístico no existe.");
			}
		}
		return centro1;
	}
	
	public Trabajadores leerTrabajador(List<Trabajadores> trabajadores, String dni ) throws BancoException {
		Trabajadores trabajador1 = null;
		boolean encontrado = false;
		Iterator<Trabajadores> e = trabajadores.iterator();
		while (!encontrado && e.hasNext()) {
			Trabajadores trabajador2 = e.next();
			if (trabajador2.getDni().equals(dni)) {
				trabajador1 = trabajador2;
				encontrado = true;
			} else {
				throw new BancoException("Este trabajador no existe.");
			}
		}
		return trabajador1;
	}
}
