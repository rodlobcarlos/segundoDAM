package inter.ServConversaciones;

import java.time.LocalDate;

import enu.ServConversaciones.TipoAgente;
import exception.ServConversaciones.ConversacionException;
import model.ServConversaciones.Conversacion;

public interface ISerConversaciones {
	
	public Conversacion agregarConversacion(Conversacion c);
	
	public Conversacion eliminarConversacion(Conversacion c);
	
	public Conversacion modificarConversacion(Conversacion c) throws ConversacionException;
	
	public Conversacion leerConversacion(String pregunta, TipoAgente tipo, LocalDate fecha) throws ConversacionException;
	
	public Conversacion incrementarValoracion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException;
}

