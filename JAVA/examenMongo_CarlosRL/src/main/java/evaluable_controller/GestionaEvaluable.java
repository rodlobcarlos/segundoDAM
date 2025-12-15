package evaluable_controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import evaluable.Evento;
import evaluable.Usuario;
import evaluable_repository.Usuario_repository;
import evaluable_service.Usuario_service;
import mongoDBconfig.MongoDBConexion;

public class GestionaEvaluable {
	
	private static final Logger logger = LogManager.getLogger(Usuario_repository.class);

	public static void main(String[] args) {

		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db = conexion.getDb();
		Usuario_repository repository = new Usuario_repository(db);
		Usuario_service service = new Usuario_service(repository);
		
		List<Usuario> lista = service.read();
		for(Usuario usuario: lista) {
			logger.info(usuario);
		}
		
		
		logger.info(service.getPorId("usr002"));
		
		logger.info(service.ordenadoPorPlan());
		logger.info(service.ordenadoPorEmail());
		
		service.eliminarPorPlan();
		service.actualizarLimiteDatos();
		service.actualizarIdioma();
		service.añadiEvento("usr008");
	}

}
