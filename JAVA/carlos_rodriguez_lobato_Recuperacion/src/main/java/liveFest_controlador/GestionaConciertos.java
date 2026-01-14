package liveFest_controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import liveFest_modelo.Concierto;
import liveFest_modelo.Escenario;
import liveFest_modelo.Grupo;
import liveFest_servicio.Festival_servicio;

public class GestionaConciertos {

	// --- Atributos ---
	private static final Logger logger = LogManager.getLogger(GestionaConciertos.class);
	private static final String resource = "conciertosFestival (1).xml"; // solo el nombre del xml añadido en \\resources\\
	private static final String rutaCSV = "src\\main\\resources\\conciertos.csv"; 


	public static void main(String[] args) throws Exception {
		
		Grupo grupo = new Grupo("Grupo1", "Cogido1", 5, "email@gmail.com");
		Concierto concierto = new Concierto(1, "Fecha1", "Esto es una descripción", Escenario.ALTERNATIVO, grupo);

		Festival_servicio servicio = new Festival_servicio();

		List<Concierto> conciertos = servicio.leerConciertoListaDesdeXML(resource);

		try {
			logger.info(servicio.leerConciertoListaDesdeXML(resource));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		servicio.escribeConcierto(conciertos, rutaCSV);
		
		logger.info(servicio.agregarGrupo(grupo)); 
		
		servicio.agregarConciertoAGrupo(concierto, grupo);
		
		logger.info(servicio.leerGrupo("Grupo1"));
	}

}
