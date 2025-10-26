package towerGPT_service;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import towerGPT_Exception.InteraccionException;
import towerGPT_model.InteraccionAgente;
import towerGPT_model.TipoAgente;
import towerGPT_repository.RepositorioInteracciones;

public class ServicioInteracciones {

    private static final Logger logger = LogManager.getLogger(ServicioInteracciones.class);

    private RepositorioInteracciones repo;

	public ServicioInteracciones(RepositorioInteracciones repo) {
		super();
		this.repo = repo;
	}

	public RepositorioInteracciones getRepo() {
		return repo;
	}

	public void setRepo(RepositorioInteracciones repo) {
		this.repo = repo;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return "ServicioInteracciones [repo=" + repo + "]";
	}
    
    public void agregarInteraccionARegistro(InteraccionAgente interaccionAgente) {
    	repo.agregarInteraccionARegistro(interaccionAgente);
    }
    
    public void actualizaPorcentajeInteraccion(InteraccionAgente interaccionAgente, double porcentajeNuevo) {
    	try {
			repo.actualizaPorcentajeInteraccion(interaccionAgente, porcentajeNuevo);
		} catch (InteraccionException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
    }
    
    public void borrarInteracciones(InteraccionAgente interaccionAgente) {
    	repo.borrarInteracciones(interaccionAgente);
    }
    
    public InteraccionAgente leerInteracciones(String id) {
    	try {
			repo.leerInteracciones(id);
		} catch (InteraccionException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return null;
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
 		for(InteraccionAgente i: repo.getRegistro()) {
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
 		for(InteraccionAgente i: repo.getRegistro()) {
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
 		for(InteraccionAgente i: repo.getRegistro()) {
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
 		for(InteraccionAgente i: repo.getRegistro()) {
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
