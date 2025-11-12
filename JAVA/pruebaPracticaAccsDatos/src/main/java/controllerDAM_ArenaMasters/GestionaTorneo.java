package controllerDAM_ArenaMasters;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelDAM_ArenaMasters.Enfrentamiento;
import modelDAM_ArenaMasters.Equipo;
import serviceDAM_ArenaMasters.TorneoService;
import utiles.LecturaEnfrentamientos;
import utiles.LecturaEquipo;

public class GestionaTorneo {

	private static final Logger logger = LogManager.getLogger(GestionaTorneo.class);

	public static void main(String[] args) {

		LecturaEquipo lecturaEquipo = new LecturaEquipo();
		LecturaEnfrentamientos lecturaEnfrentamiento = new LecturaEnfrentamientos();
		TorneoService service = new TorneoService();
		
		List<Equipo> equipos = service.leerEquipo("partidasTorneo.xml");
		List<Enfrentamiento> enfrentamientos = service.leerEnfrentamiento("partidasTorneo.xml");
		logger.info(equipos);
		logger.info(enfrentamientos);
	}
}
