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
		
	public double getValoracionMediaParaHumanos() {
		double valor_humano = 0;
		double contador = 0;
		for (Conversacion c : repo.getConversaciones()) {
			contador++;
			if (c.getAgente().equals(TipoAgente.HUMANO)) {
				valor_humano++;
			}
		}
		double valor_media = valor_humano/contador;
		return valor_media;
	}

	public double getValoracionMedidaParaBots() {
		double valor_bot = 0;
		double contador = 0;
		for (Conversacion c : repo.getConversaciones()) {
			contador++;
			if (c.getAgente().equals(TipoAgente.IA)) {
				valor_bot++;
			}
		}
		double valor_media = valor_bot/contador;
		return valor_media;
	}
}
