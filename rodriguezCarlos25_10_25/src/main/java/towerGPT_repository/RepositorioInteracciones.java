package towerGPT_repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import towerGPT_Exception.InteraccionException;
import towerGPT_model.InteraccionAgente;
import towerGPT_model.TipoAgente;

public class RepositorioInteracciones {
	
    private static final Logger logger = LogManager.getLogger(RepositorioInteracciones.class);

	private Set<InteraccionAgente> registro;

	public Set<InteraccionAgente> getRegistro() {
		return registro;
	}

	public void setRegistro(Set<InteraccionAgente> registro) {
		this.registro = registro;
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
	
	public void borrarInteracciones(InteraccionAgente interaccionAgente) {
		registro.remove(interaccionAgente);
	}
	
	public InteraccionAgente leerInteracciones(String id) throws InteraccionException {
		InteraccionAgente agente = null;
		boolean esEncontrado = false;
		Iterator<InteraccionAgente> i = registro.iterator();
		while(!esEncontrado && i.hasNext()) {
			InteraccionAgente agente2 = i.next();
			if(agente2.getId().equals(id)) {
				esEncontrado = true;
				agente = agente2;
			}else {
				throw new InteraccionException("Esta interacción no existe.");
			}
		}
		return agente;
	}	
}
