package repositoryDAM_ArenaMasters;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptionDAM_ArenaMasters.TorneoException;
import modelDAM_ArenaMasters.Equipo;

public class RepositoryEquipo {

	private List<Equipo> listaEquipo;
	private static final Logger logger = LogManager.getLogger(RepositoryEnfrentamiento.class);

	public List<Equipo> getListaEquipo() {
		return listaEquipo;
	}

	public void setListaEquipo(List<Equipo> listaEquipo) {
		this.listaEquipo = listaEquipo;
	}

	public RepositoryEquipo() {
		super();
		this.listaEquipo = listaEquipo;
	}

	@Override
	public String toString() {
		return "RepositoryEquipo [listaEquipo=" + listaEquipo + "]";
	}

	public Equipo getEquipo(String codigo) throws TorneoException {
		Equipo equipo1 = null;
		boolean encontrado = false;
		Iterator<Equipo> e = listaEquipo.iterator();
		while (!encontrado && e.hasNext()) {
			Equipo equipo2 = e.next();
			if (equipo2.getCodigo().equals(codigo)) {
				equipo1 = equipo2;
				encontrado = true;
			} else {
				throw new TorneoException("Este equipo no existe.");
			}
		}
		return equipo1;
	}

	public void agregarEquipo(Equipo equipo) throws TorneoException {
		if (!listaEquipo.contains(equipo.getCodigo())) {
			listaEquipo.add(equipo);
		} else {
			throw new TorneoException("Ya existe un equipo con el mismo código.");
		}
	}
}
