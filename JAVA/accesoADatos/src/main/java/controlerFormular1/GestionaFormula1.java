package controlerFormular1;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelF1.Equipo;
import modelF1.Piloto;
import serviceF1.ServiceF1;

public class GestionaFormula1 {
	private static final Logger logger = LogManager.getLogger(GestionaFormula1.class);

	public static void main(String[] args) {

		ServiceF1 service = new ServiceF1();
		List<Piloto> pilotos = service.leerPilotoDesdeXML();
		List<Equipo> equipos = service.leerEquipoDesdeXML();
//		logger.info(pilotos);
//		logger.info(equipos);

		try {
			logger.info(service.puntuacionMayorNumero(4, "formula1.xml", pilotos));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			service.listaPilotosEquipos(pilotos, equipos);
			logger.info(equipos);
			service.escribeEquipoXML(equipos, "pilotos.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
