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
		
		Random numero = new Random(6);
		logger.debug("Iniciando ejecución del logger: ");
		Set<Conversacion> conversacion = new HashSet<Conversacion>();
		ConversacionRepository cr = new ConversacionRepository(conversacion);
		ConversacionService cs = new ConversacionService(cr);
		Conversacion c = new Conversacion(1, LocalDate.now(), Random.from(numero), TipoAgente.HUMANO, "¿Qué día es hoy?", "¿Miércoles?", 10);
		
		logger.debug(cs.agregarConversacion(c));

	}
}
