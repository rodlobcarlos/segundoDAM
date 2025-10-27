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
		InteraccionAgente i1 = new InteraccionAgente(TipoAgente.HUMANO, "peticion1", "peticion recibida", 70, 10, 10);
		InteraccionAgente i2 = new InteraccionAgente(TipoAgente.IA, "peticion2", "peticion recibida", 60, 5, 7);
		InteraccionAgente i3 = new InteraccionAgente(TipoAgente.HUMANO, "peticion3", "peticion recibida", 94, 8, 4);
		InteraccionAgente i4 = new InteraccionAgente(TipoAgente.IA, "peticion4", "peticion recibida", 20, 6, 3);

		repo.agregarInteraccionARegistro(i1);
		repo.agregarInteraccionARegistro(i2);
		repo.agregarInteraccionARegistro(i3);
		repo.agregarInteraccionARegistro(i4);

		logger.debug(registro);

				
//		repo.borrarInteracciones(i3);
		
		serv.actualizaPorcentajeInteraccion(i1, 9);
		serv.actualizaPorcentajeInteraccion(i4, 2);

		logger.info(serv.leerInteracciones(3));

		logger.info(serv.obtenerInteraccionConMayorValoracion());
		
		logger.info(serv.calcularTiempoMedioPorTipo(TipoAgente.HUMANO));
		logger.info(serv.calcularTiempoMedioPorTipo(TipoAgente.IA));
		
		logger.info(serv.calcularPorcentajeMedioPorTipos(TipoAgente.HUMANO));
		logger.info(serv.calcularPorcentajeMedioPorTipos(TipoAgente.IA));

		logger.info(serv.agruparInteraccionesPorTipo(TipoAgente.HUMANO));	
		logger.info(serv.agruparInteraccionesPorTipo(TipoAgente.IA));	
		
		serv.escribeRegistro(registro, "src\\main\\resources\\agente.json");

		serv.leeRegistro("src\\main\\resources\\agente.json");
		
		serv.escrituraCsv("src\\main\\resources\\agente.csv");
		
		serv.leeCsv("src\\main\\resources\\agente.csv");
		
		serv.grabarResumenEstadistica("src\\main\\resources\\resumenEstadistica.txt", registro);
		
	}
}
