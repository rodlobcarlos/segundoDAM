package controller.ServConversaciones;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import enu.ServConversaciones.TipoAgente;
import model.ServConversaciones.Conversacion;
import repository.ServConversaciones.ConversacionRepository;
import service.ServConversaciones.ConversacionService;

public class GestionaPeticionesAChat {
	
	private static final Logger logger =  LogManager.getLogger(GestionaPeticionesAChat.class);

	public static void main(String[] args) {
		logger.info("Iniciando ejecución del logger: ");

		Random numero = new Random();
		
		Set<Conversacion> conversacion = new HashSet<Conversacion>();
		ConversacionRepository cr = new ConversacionRepository(conversacion);
		ConversacionService cs = new ConversacionService(cr);
		Conversacion c1 = new Conversacion(1, LocalDate.now(), numero.nextInt(100), TipoAgente.HUMANO, "¿Qué día es hoy?", "Miércoles", 10.0);
		Conversacion c3 = new Conversacion(3, LocalDate.now(), numero.nextInt(100), TipoAgente.HUMANO, "¿Qué día es hoy?", "Martes", 5.0);
		Conversacion c4 = new Conversacion(4, LocalDate.of(2025, 01, 30), numero.nextInt(100), TipoAgente.HUMANO, "¿Qué día es mañana?", "Lunes", 3.0);
		Conversacion c5 = new Conversacion(5, LocalDate.now(), numero.nextInt(100), TipoAgente.HUMANO, "¿Qué día es hoy?", "Viernes", 9.0);
		Conversacion c2 = new Conversacion(2, LocalDate.now(), numero.nextInt(100), TipoAgente.IA, "¿Qué día es hoy?", "Jueves", 7.0);

		
		logger.info("Conversacion añadida: " + conversacion.add(c1));
		logger.info("Conversacion añadida: " + conversacion.add(c1)); // Repetido no se añade
		logger.info("Conversacion añadida: " + conversacion.add(c2));
		logger.info("Conversacion añadida: " + conversacion.add(c3));
		logger.info("Conversacion añadida: " + conversacion.add(c4));
		logger.info("Conversacion añadida: " + conversacion.add(c5));

		// Código que comprobar
		logger.info("Conversacion agregada: " + cs.agregarConversacion(c1));
		logger.info("Conversacion agregada: " + cs.agregarConversacion(c2));
		logger.info("Conversacion agregada: " + cs.agregarConversacion(c4));

		// --
		
		// Valoraciones 
		logger.debug(cs.getValoracionMediaParaHumanos());
		logger.debug(cs.getValoracionMedidaParaBots());

		// Comprobar código
		logger.debug(cs.incrementarValoracion(LocalDate.of(2025, 01, 30), TipoAgente.HUMANO, "¿Qué día es mañana?"));
		
		logger.debug(cs.leerConversacion("¿Qué día es mañana?", TipoAgente.HUMANO,  LocalDate.of(2025, 01, 30)));
		
		logger.debug(cs.modificarConversacion(c5));
		
		// Listado
		logger.debug(conversacion);

	}
}
