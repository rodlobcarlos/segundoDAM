package towerGPT_repository;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import towerGPT_Exception.InteraccionException;
import towerGPT_model.InteraccionAgente;
import towerGPT_model.TipoAgente;

public class RepositorioInteracciones {

	private static final Logger logger =  LogManager.getLogger(InteraccionAgente.class);

	private Set<InteraccionAgente> registro;

	public Set<InteraccionAgente> getRegistro() {
		return registro;
	}

	public void setRegistro(Set<InteraccionAgente> registro) {
		this.registro = registro;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return "RepositorioInteracciones [registro=" + registro + "]";
	}

	public RepositorioInteracciones(Set<InteraccionAgente> registro) {
		super();
		this.registro = registro;
	}
	
	public void agregarInteraccionARegistro(InteraccionAgente interaccionAgente) {
		registro.add(interaccionAgente);
	}
	
	public boolean actualizaPorcentajeInteraccion(InteraccionAgente interaccionAgente, double porcentajeNuevo) throws InteraccionException {
		boolean esActualizado;
		if(interaccionAgente.getPorcentajeAcierto() != porcentajeNuevo) {
			esActualizado = true;
			interaccionAgente.setPorcentajeAcierto(porcentajeNuevo);
		}else {
			throw new InteraccionException("Este porcentaje de acierto no es distinto al que ya teniamos.");
		}
		return esActualizado;
	}
	
	// REVISAR
	public double incrementarNumeroValoraciones(InteraccionAgente interaccionAgente, double valoracionNueva) throws InteraccionException {
		if(interaccionAgente.getValoracion() != valoracionNueva) {
			valoracionNueva +=1;
		}else {
			throw new InteraccionException("No es posible incrementar la valoración.");
		}
		return valoracionNueva;
	}
	
	// REVISAR
	public InteraccionAgente obtenerInteraccionConMayorValoracion() {
		// contador = 0;
		double mayor = 0;
		for(InteraccionAgente i: registro) {
			if(i.getValoracion() > mayor) {
				mayor = i.getValoracion();
				// contador++;
				logger.info("La mayor valoración es: ",mayor);
			}
		}
		return null;
	}
	
	public int calcularTiempoMedioPorTipo(TipoAgente agente) {
		int sumaDelTipo = 0;
		int contador = 0;
		for(InteraccionAgente i: registro) {
			if(i.getTipo().equals(agente.HUMANO) || i.getTipo().equals(agente.IA)) {
				sumaDelTipo += i.getTimepoEjecucion();
				contador++;
			}
		}
		int mediaTiempo = sumaDelTipo / contador;
		return mediaTiempo;
		
	}
	
	public int calcularPorcentajeMedioPorTipos(TipoAgente agente) {
		int sumaDelTipo = 0;
		int contador = 0;
		for(InteraccionAgente i: registro) {
			if(i.getTipo().equals(agente.HUMANO) || i.getTipo().equals(agente.IA)) {
				sumaDelTipo += i.getPorcentajeAcierto();
				contador++;
			}
		}
		int mediaTiempo = sumaDelTipo / contador;
		return mediaTiempo;
		
	}
	
	//obtenerInteraccionesAciertoMayorQueOrdenadas
	
	public void agruparInteraccionesPorTipo(TipoAgente agente) {
		Set<InteraccionAgente> tipoHumano = new HashSet<InteraccionAgente>();
		Set<InteraccionAgente> tipoIA = new HashSet<InteraccionAgente>();
		for(InteraccionAgente i: registro) {
			if(i.getTipo().equals(agente.HUMANO)) {
				tipoHumano.add(i);
				logger.info(tipoHumano);
			}else {
				tipoIA.add(i);
				logger.info(tipoIA);
			}
		}
	}
	
	
}
