package service.ServConversaciones;

import java.time.LocalDate;

import enu.ServConversaciones.TipoAgente;
import exception.ServConversaciones.ConversacionException;
import inter.ServConversaciones.ISerConversaciones;
import model.ServConversaciones.Conversacion;
import repository.ServConversaciones.ConversacionRepository;

public class ConversacionService implements ISerConversaciones{

	private ConversacionRepository repo;
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Conversacion leerConversacion(String pregunta, TipoAgente tipo, LocalDate fecha) {
		try {
			repo.leerConversacion(pregunta, tipo, fecha);
		} catch (ConversacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Conversacion incrementarValoracion(LocalDate fecha, TipoAgente tipo, String pregunta) {
		try {
			repo.incrementarValoracion(fecha, tipo, pregunta);
		} catch (ConversacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public double getValoracionMediaHumanos(TipoAgente tipo) {
		// TERMINAR
		return 0;
		
	}
}
