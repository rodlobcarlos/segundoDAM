package serviceDAM_ArenaMasters;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptionDAM_ArenaMasters.TorneoException;
import modelDAM_ArenaMasters.Enfrentamiento;
import modelDAM_ArenaMasters.Equipo;
import repositoryDAM_ArenaMasters.RepositoryEnfrentamiento;
import repositoryDAM_ArenaMasters.RepositoryEquipo;
import utiles.LecturaEnfrentamientos;
import utiles.LecturaEquipo;

public class TorneoService {

	private RepositoryEquipo repoEquipo;
	private RepositoryEnfrentamiento repoEnfrentamiento;
	private LecturaEnfrentamientos leerEnfrent;
	private LecturaEquipo leerEquipo;
	private static final Logger logger = LogManager.getLogger(RepositoryEnfrentamiento.class);
	
	

	public TorneoService() {
		super();
		this.repoEquipo = new RepositoryEquipo();
		this.repoEnfrentamiento = new RepositoryEnfrentamiento();
		this.leerEnfrent = new LecturaEnfrentamientos();
		this.leerEquipo = new LecturaEquipo();
	}

	@Override
	public String toString() {
		return "TorneoService [repoEquipo=" + repoEquipo + ", repoEnfrentamiento=" + repoEnfrentamiento + "]";
	}

	public RepositoryEquipo getRepoEquipo() {
		return repoEquipo;
	}

	public void setRepoEquipo(RepositoryEquipo repoEquipo) {
		this.repoEquipo = repoEquipo;
	}

	public RepositoryEnfrentamiento getRepoEnfrentamiento() {
		return repoEnfrentamiento;
	}

	public void setRepoEnfrentamiento(RepositoryEnfrentamiento repoEnfrentamiento) {
		this.repoEnfrentamiento = repoEnfrentamiento;
	}
	
	
	public void agregarListaEquipos(List<Equipo> equipos, Equipo equipo) {
		try {
			repoEquipo.agregarEquipo(equipo);
		} catch (TorneoException e1) {
			logger.error("Error.");
			equipos.add(equipo);
		} 
	}
	
	public void agregarListaEnfrentamientos(List<Enfrentamiento> enfrentamientos, Enfrentamiento enfrentamiento, Equipo equipo) {
		try {
			repoEnfrentamiento.agregarEnfrentamiento(enfrentamiento, equipo);
		} catch (TorneoException e) {
			logger.error("Error");
			enfrentamientos.add(enfrentamiento);
		}
	}
	
//	public List<Enfrentamiento> obtenerListaEnfrentamientos(Equipo equipo, String cogido) {
//		for(Enfrentamiento enf: )
//		return null;
//	}
	
	public List<Equipo> leerEquipo(String rutaFichero) {
		List<Equipo> equipos = new ArrayList<Equipo>();
		try {
			equipos = leerEquipo.leerEquipoDesdeXML("partidasTorneo.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipos;
	}
	
	public List<Enfrentamiento> leerEnfrentamiento(String rutaFichero){
		List<Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
		try {
			enfrentamientos = leerEnfrent.leerEnfrentamientoDesdeXML(rutaFichero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enfrentamientos;
		
	}
}
