package simulacroFormula1_service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import simulacroFormula1_model.Pilot;
import simulacroFormula1_model.Team;
import simulacroFormula1_repository.TeamRepository;
import simulacroFormula1_suplies.XMLDomPiltos;
import simulacroFormula1_suplies.XMLDomTeams;

public class F1Service {

	private TeamRepository repository;
	private XMLDomTeams domTeams;
	private XMLDomPiltos domPiltos;

	public TeamRepository getRepository() {
		return repository;
	}

	public void setRepository(TeamRepository repository) {
		this.repository = repository;
	}

	public XMLDomTeams getDomTeams() {
		return domTeams;
	}

	public void setDomTeams(XMLDomTeams domTeams) {
		this.domTeams = domTeams;
	}

	public XMLDomPiltos getDomPiltos() {
		return domPiltos;
	}

	public void setDomPiltos(XMLDomPiltos domPiltos) {
		this.domPiltos = domPiltos;
	}

	@Override
	public String toString() {
		return "F1Service [repository=" + repository + ", domTeams=" + domTeams + ", domPiltos=" + domPiltos + "]";
	}

	public F1Service() {
		super();
		this.repository = new TeamRepository();
		this.domTeams = new XMLDomTeams();
		this.domPiltos = new XMLDomPiltos();
	}

	public List<Team> leerTeamListDesdeXML(String rutaFichero) throws Exception {
		return domTeams.leerTeamListDesdeXML(rutaFichero);
	}

	public List<Pilot> leerPilotListDesdeXML(String rutaFichero) throws Exception {
		return domPiltos.leerPilotListDesdeXML(rutaFichero);
	}

	public List<Pilot> puntuacionMayorAParametro(int number) throws Exception {
		List<Pilot> list = new ArrayList<Pilot>();
		List<Pilot> pilots = domPiltos.leerPilotListDesdeXML("formula1.xml");
		for (Pilot p : pilots) {
			if (p.getPoints() > number) {
				list.add(p);
			}
		}
		return list;
	}

	// JSON
	public void escribePilots(List<Pilot> list, String ruta) { // Convertir el objeto a JSON
		List<Pilot> productsList = new ArrayList<Pilot>();
		for (Pilot p : list) {
			if (p.getPoints() > 4) {
				productsList.add(p);
			}
			Gson gson = new Gson();
			String json = gson.toJson(productsList);

			// Escribir el JSON en un archivo
			FileWriter writer = null;

			try {
				writer = new FileWriter(ruta);
				writer.write(json);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public void escribeTeamsEnXML(String nombreFichero, List<Team> t) {
		domTeams.escribeTeamsEnXML(nombreFichero, t);
	}
}
