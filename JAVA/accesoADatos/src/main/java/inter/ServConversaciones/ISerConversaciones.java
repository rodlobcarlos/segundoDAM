package inter.ServConversaciones;

import java.time.LocalDate;

import enu.ServConversaciones.TipoAgente;
import exception.ServConversaciones.ConversacionException;
import model.ServConversaciones.Conversacion;

public interface ISerConversaciones {

	public static final double valoracionMediaHumanos = 0;
	public static final double valoracionMediaBots = 0;
	
	public void agregarConversacion(Conversacion c);
	
	public void eliminarConversacion(Conversacion c);
	
	public boolean modificarConversacion(Conversacion c) throws ConversacionException;
	
	public Conversacion leerConversacion(String pregunta, TipoAgente tipo, LocalDate fecha) throws ConversacionException;
	
	public Conversacion incrementarValoracion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException;
}

