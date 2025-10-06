package repository.ServConversaciones;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.ServConversaciones.GestionaPeticionesAChat;
import enu.ServConversaciones.TipoAgente;
import exception.ServConversaciones.ConversacionException;
import inter.RepoConversaciones.IRepoConversaciones;
import model.ServConversaciones.Conversacion;

public class ConversacionRepository implements IRepoConversaciones{

	private Set<Conversacion> conversaciones;
	
	private static final Logger logger =  LogManager.getLogger(ConversacionRepository.class);


	public Set<Conversacion> getConversaciones() {
		return conversaciones;
	}

	public void setConversaciones(Set<Conversacion> conversaciones) {
		this.conversaciones = conversaciones;
	}

	public ConversacionRepository(Set<Conversacion> conversaciones) {
		super();
		this.conversaciones = new HashSet<Conversacion>();
	}

	@Override
	public String toString() {
		return "ConversacionRepository [conversaciones=" + conversaciones + "]";
	}
	
	public Conversacion agregarConversacion(Conversacion c) {
		conversaciones.add(c);
		return c;
	}
	
	public Conversacion eliminarConversacion(Conversacion c) {
		 conversaciones.remove(c);
		return c;
	}
	
	public Conversacion modificarConversacion(Conversacion c) throws ConversacionException {
		boolean esModificado = false;
		if(conversaciones.contains(c)) {
			Conversacion conversacion = leerConversacion(c.getPregunta(),c.getAgente(),c.getFechaRegistro());
			conversaciones.remove(conversacion);
			conversaciones.add(c);
			esModificado = true;
		}else {
			throw new ConversacionException("Esta conversación no existe.");
		}
		return c;
	}
	
	public Conversacion leerConversacion(String pregunta, TipoAgente tipo, LocalDate fecha) throws ConversacionException {
		Conversacion conv1 = null;
		boolean esEncontrado = false;
		Iterator<Conversacion> c = conversaciones.iterator();
		while (!esEncontrado & c.hasNext()) {
			Conversacion conv2 = c.next();
			if(conv2.getPregunta().equals(pregunta) && conv2.getAgente().equals(tipo)
					&& conv2.getFechaRegistro().equals(fecha)) {
				conv1 = conv2;
				esEncontrado = true;
			}
			throw new ConversacionException("Esta conversación no existe.");
		}
		return conv1;
	}

	public Conversacion incrementarValoracion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
		Conversacion c = leerConversacion(pregunta, tipo, fecha);
		double incrementar = c.getValoracion() + 1;
		c.setValoracion(incrementar);
		return c;
	}
}
