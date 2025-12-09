package simulacroMongoDB_controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import mongoDBconfig.MongoDBConexion;
import simulacroMongoDB_model.Hotel;
import simulacroMongoDB_repository.Hotel_repository;
import simulacroMongoDB_service.Hotel_service;


public class GestionaHoteles {
	
	private static final Logger logger = LogManager.getLogger(Hotel_repository.class);


	public static void main(String[] args) {

		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db = conexion.getDb();
		Hotel_repository repository = new Hotel_repository(db);
		Hotel_service service = new Hotel_service(repository);
		
		List<Hotel> hotels = service.read();
		service.mediaEstrellas();
		
//		for(Hotel hotel: hotels) {
//			logger.info(hotel);
//		}

	}

}
