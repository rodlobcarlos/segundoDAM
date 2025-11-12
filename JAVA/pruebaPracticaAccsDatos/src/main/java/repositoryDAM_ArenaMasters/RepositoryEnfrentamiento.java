package repositoryDAM_ArenaMasters;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptionDAM_ArenaMasters.TorneoException;
import modelDAM_ArenaMasters.Enfrentamiento;
import modelDAM_ArenaMasters.Equipo;

public class RepositoryEnfrentamiento {

	private static final Logger logger = LogManager.getLogger(RepositoryEnfrentamiento.class);
 
	private List<Enfrentamiento> listaEnfrentamientos;

	public List<Enfrentamiento> getListaEnfrentamientos() {
		return listaEnfrentamientos;
	}

	public void setListaEnfrentamientos(List<Enfrentamiento> listaEnfrentamientos) {
		this.listaEnfrentamientos = listaEnfrentamientos;
	}

	public RepositoryEnfrentamiento() {
		super();
		this.listaEnfrentamientos = listaEnfrentamientos;
	}

	@Override
	public String toString() {
		return "RepositoryEnfrentamiento [listaEnfrentamientos=" + listaEnfrentamientos + "]";
	}
	
	public void agregarEnfrentamiento(Enfrentamiento enfrentamiento, Equipo equipo) throws TorneoException {
		RepositoryEquipo equipos = new RepositoryEquipo();
		if(!equipos.getListaEquipo().contains(enfrentamiento.getEquipoGanador().equals(equipo.getCodigo()))) {
			throw new TorneoException("No existe equipo ganador con ese codigo en la lista de equipos.");
		}
	}
}
