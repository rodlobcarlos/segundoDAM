package towerGPT_controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import towerGPT_Exception.InteraccionException;
import towerGPT_model.InteraccionAgente;
import towerGPT_model.TipoAgente;
import towerGPT_repository.RepositorioInteracciones;
import towerGPT_service.ServicioInteracciones;

public class MainApp {
    private static final Logger logger = LogManager.getLogger(RepositorioInteracciones.class);


	public static void main(String[] args) {
		Set<InteraccionAgente> registro = new HashSet<InteraccionAgente>();
		RepositorioInteracciones repo = new RepositorioInteracciones(registro);
		ServicioInteracciones serv = new ServicioInteracciones(repo);
		InteraccionAgente i1 = new InteraccionAgente("1", TipoAgente.HUMANO, "peticion1", "peticion recibida", 70, 10, 10);
		InteraccionAgente i2 = new InteraccionAgente("2", TipoAgente.IA, "peticion2", "peticion recibida", 60, 5, 7);
		InteraccionAgente i3 = new InteraccionAgente("3", TipoAgente.HUMANO, "peticion3", "peticion recibida", 94, 8, 4);
		InteraccionAgente i4 = new InteraccionAgente("4", TipoAgente.IA, "peticion4", "peticion recibida", 20, 6, 3);

		//FUNCIONA
		repo.agregarInteraccionARegistro(i1);
		repo.agregarInteraccionARegistro(i2);
		repo.agregarInteraccionARegistro(i3);
		repo.agregarInteraccionARegistro(i4);
		
		//FUNCIONA
//		repo.borrarInteracciones(i3);
		
		
		// FUNCIONA
		try {
			repo.actualizaPorcentajeInteraccion(i1, 9);
			repo.actualizaPorcentajeInteraccion(i4, 6.7);
		} catch (InteraccionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//FUNCIONA
		try {
			logger.debug(repo.leerInteracciones("1"));
		} catch (InteraccionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//REVISAR
		logger.info(serv.obtenerInteraccionConMayorValoracion());
		
		//REVISAR
		logger.info(serv.calcularTiempoMedioPorTipo(TipoAgente.HUMANO));
		logger.info(serv.calcularTiempoMedioPorTipo(TipoAgente.IA));
		
		//REVISAR
		logger.info(serv.calcularPorcentajeMedioPorTipos(TipoAgente.HUMANO));
		logger.info(serv.calcularPorcentajeMedioPorTipos(TipoAgente.IA));

		//REVISAR
		logger.info(serv.agruparInteraccionesPorTipo(TipoAgente.HUMANO));	
		logger.info(serv.agruparInteraccionesPorTipo(TipoAgente.IA));	
		
		// FUNCIONA
		serv.escribeRegistro(registro, "src\\main\\resources\\agente.json");

		//REVISAR
		serv.leeRegistro("src\\main\\resources\\agente.json");
		
		//FUNCIONA
		serv.escrituraCsv("src\\main\\resources\\agente.csv");
		
		//REVISASR
		serv.leeCsv("src\\main\\resources\\agente.csv");
		logger.debug(registro);
		
	}
}
