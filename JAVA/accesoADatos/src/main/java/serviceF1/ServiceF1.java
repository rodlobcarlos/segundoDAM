package serviceF1;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelF1.Equipo;
import modelF1.Piloto;
import repositoryF1.RepositoryEquiposF1;
import repositoryF1.RepositoryPilotos;

public class ServiceF1 {

	private static final Logger logger = LogManager.getLogger(RepositoryEquiposF1.class);

	private RepositoryEquiposF1 repoEquipo;
	private RepositoryPilotos repoPiloto;
	
	@Override
	public String toString() {
		return "ServiceF1 [repoEuipo=" + repoEquipo + ", repoPiloto=" + repoPiloto + "]";
	}

	public ServiceF1() {
		super();
		this.repoEquipo = new RepositoryEquiposF1();
		this.repoPiloto = new RepositoryPilotos();

	}

	public RepositoryEquiposF1 getRepo() {
		return repoEquipo;
	}

	public void setRepo(RepositoryEquiposF1 repoEquipo) {
		this.repoEquipo = repoEquipo;
	}
	
	public void listaPilotosEquipos(List<Piloto> listaPilotos, List<Equipo> listaEquipos) throws Exception {
		for(Equipo e: listaEquipos) {
			List<Piloto> pilotos = new ArrayList<Piloto>();
			int id = e.getIdentificadorEquipo();
			for(Piloto p: listaPilotos) {
				if(p.getIdentificadorEquipo() == id) {
					pilotos.add(p);
				}
			}
			e.setListaPilotos(pilotos);
		}
	}
	public List<Piloto> puntuacionMayorNumero(int numero, String rutaFichero, List<Piloto>pilotos) throws Exception{
		List<Piloto> lista = new ArrayList<Piloto>();
		for(Piloto p: pilotos) {
			if(p.getPuntos() > numero) {
				lista.add(p);
			}
		}
		return lista;
	}
	
	public List<Piloto> leerPilotoDesdeXML() {
		List<Piloto> piloto = null;
		try {
			piloto = repoPiloto.leerPilotoDesdeXML("formula1.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return piloto;
	}
	
	 public List<Equipo> leerEquipoDesdeXML() {
		 List<Equipo> equipo= null;
		 try {
			equipo = repoEquipo.leerEquipoDesdeXML("formula1.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipo;
	 }
	 
	 public void escribeEquipoXML(List<Equipo> equipos, String nuevoFichero) {
		 repoEquipo.escribeEquipoXML(equipos, nuevoFichero);
	 }
}
