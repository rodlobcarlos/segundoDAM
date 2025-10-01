package inter.RepoConversaciones;

import java.time.LocalDate;

import enu.ServConversaciones.TipoAgente;
import exception.ServConversaciones.ConversacionException;
import model.ServConversaciones.Conversacion;

public interface IRepoConversaciones {

	public void agregarConversacion(Conversacion c);
	
	public void eliminarConversacion(Conversacion c);
	
	public boolean modificarConversacion(Conversacion c) throws ConversacionException;
	
	public Conversacion leerConversacion(String pregunta, TipoAgente tipo, LocalDate fecha) throws ConversacionException;
	
	public Conversacion incrementarValoracion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException;
}
