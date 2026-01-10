package simulacroFormula1_controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simulacroFormula1_model.Pilot;
import simulacroFormula1_model.Team;
import simulacroFormula1_service.F1Service;

public class F1Manage {

	private static final Logger logger = LogManager.getLogger(F1Manage.class);
	private static final String resource = "formula1.xml";
	private static final String newfileNameJSON = "src\\main\\resources\\productosNOenVenta.json";
	private static final String newfileNameXML = "Teams.xml";


	public static void main(String[] args) throws Exception {

		F1Service service = new F1Service();
		
		List<Team> listTeam = service.leerTeamListDesdeXML(resource);

		try {
			logger.info(service.leerTeamListDesdeXML(resource));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Pilot> pilots = service.leerPilotListDesdeXML(resource);

		logger.info(pilots);

		logger.info(service.puntuacionMayorAParametro(4));

		service.escribePilots(pilots, newfileNameJSON);
		
		service.escribeTeamsEnXML(newfileNameXML, listTeam);
	}

}
