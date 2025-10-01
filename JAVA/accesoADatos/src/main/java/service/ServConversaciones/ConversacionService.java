package service.ServConversaciones;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.ServConversaciones.GestionaPeticionesAChat;
import enu.ServConversaciones.TipoAgente;
import exception.ServConversaciones.ConversacionException;
import inter.ServConversaciones.ISerConversaciones;
import model.ServConversaciones.Conversacion;
import repository.ServConversaciones.ConversacionRepository;

public class ConversacionService implements ISerConversaciones{

	private ConversacionRepository repo;
	private static final Logger logger =  LogManager.getLogger(GestionaPeticionesAChat.class);

	
	public ConversacionRepository getRepo() {
		return repo;
	}

	public void setRepo(ConversacionRepository repo) {
		this.repo = repo;
	}

	public ConversacionService(ConversacionRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void agregarConversacion(Conversacion c) {
		repo.agregarConversacion(c);
	}

	@Override
	public void eliminarConversacion(Conversacion c) {
		repo.eliminarConversacion(c);
	}

	@Override
	public boolean modificarConversacion(Conversacion c)  {
		try {
			repo.modificarConversacion(c);
		} catch (ConversacionException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public Conversacion leerConversacion(String pregunta, TipoAgente tipo, LocalDate fecha) {
		try {
			repo.leerConversacion(pregunta, tipo, fecha);
		} catch (ConversacionException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Conversacion incrementarValoracion(LocalDate fecha, TipoAgente tipo, String pregunta) {
		try {
			repo.incrementarValoracion(fecha, tipo, pregunta);
		} catch (ConversacionException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public double getValoracionMediaHumanos(TipoAgente tipo) {
		Set<Conversacion> conversaciones = new HashSet<Conversacion>();
		for(Conversacion c : conversaciones) {
			double valoracionTotal = c.getValoracion() + c.getValoracion();
			if(c.getAgente().equals(tipo.HUMANO)) {
				double valoracionMediaHumanos = valoracionTotal / c.getValoracion();
			}
		}
		return valoracionMediaHumanos;
	}
	
	public double getValoracionMediaBots(TipoAgente tipo) {
		Set<Conversacion> conversaciones = new HashSet<Conversacion>();
		for(Conversacion c : conversaciones) {
			double valoracionTotal = c.getValoracion() + c.getValoracion();
			if(c.getAgente().equals(tipo.IA)) {
				double valoracionMediaHumanos = valoracionTotal / c.getValoracion();
			}
		}
		return valoracionMediaHumanos;		
	}
}
