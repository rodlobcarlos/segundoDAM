package service.ServConversaciones;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import controller.ServConversaciones.GestionaPeticionesAChat;
import enu.ServConversaciones.TipoAgente;
import exception.ServConversaciones.ConversacionException;
import inter.ServConversaciones.ISerConversaciones;
import model.ServConversaciones.Conversacion;
import repository.ServConversaciones.ConversacionRepository;

public class ConversacionService implements ISerConversaciones{

	private ConversacionRepository repo;
	private static final Logger logger =  LogManager.getLogger(GestionaPeticionesAChat.class);
	
	public ConversacionService(ConversacionRepository repo) {
		super();
		this.repo = repo;
	}

	public ConversacionRepository getRepo() {
		return repo;
	}

	public void setRepo(ConversacionRepository repo) {
		this.repo = repo;
	}

	@Override
	public Conversacion agregarConversacion(Conversacion c) {
		repo.agregarConversacion(c);
		return c;
	}

	@Override
	public Conversacion eliminarConversacion(Conversacion c) {
		repo.eliminarConversacion(c);
		return c;
	}

	@Override
	public Conversacion modificarConversacion(Conversacion c)  {
		try {
			repo.modificarConversacion(c);
		} catch (ConversacionException e) {
			logger.error("Error al modificar la conversacion: ", e);
		}
		return c;
	}

	@Override
	public Conversacion leerConversacion(String pregunta, TipoAgente tipo, LocalDate fecha) {
		try {
			repo.leerConversacion(pregunta, tipo, fecha);
		} catch (ConversacionException e) {
			// TODO Auto-generated catch block
			logger.error("Error al leer la conversacion: ", e);
		}
		return null;
	}

	@Override
	public Conversacion incrementarValoracion(LocalDate fecha, TipoAgente tipo, String pregunta) {
		try {
			repo.incrementarValoracion(fecha, tipo, pregunta);
		} catch (ConversacionException e) {
			logger.error("Error al incrementar la valoracion: ", e);
		}
		return null;
	}

	public double getValoracionMediaHumanos(TipoAgente tipo) {
		double suma = 0;
		double contador = 0;
		double media = 0;
		Set<Conversacion> conversaciones = new HashSet<Conversacion>();
		for(Conversacion c : conversaciones) {
			contador = contador +1;
			if(c.getAgente().equals(tipo.HUMANO)) {
				suma = suma + 1;
			}
		}
		media = suma / contador;
		return media;
	}
	
	public double getValoracionMediaBots(TipoAgente tipo) {
		double suma = 0;
		double contador = 0;
		double media = 0;
		Set<Conversacion> conversaciones = new HashSet<Conversacion>();
		for(Conversacion c : conversaciones) {
			contador = contador + 1;
			if(c.getAgente().equals(tipo.IA)) {
				suma = suma + 1;
			}
		}
		media = suma / contador;
		return media;
	}
}
