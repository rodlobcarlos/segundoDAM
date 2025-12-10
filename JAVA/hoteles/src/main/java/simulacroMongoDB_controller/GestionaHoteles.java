package simulacroMongoDB_controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import mongoDBconfig.MongoDBConexion;
import simulacroMongoDB_model.Coordenadas;
import simulacroMongoDB_model.Habitacion;
import simulacroMongoDB_model.Hotel;
import simulacroMongoDB_model.Tipo;
import simulacroMongoDB_model.Ubicacion;
import simulacroMongoDB_repository.Hotel_repository;
import simulacroMongoDB_service.Hotel_service;

public class GestionaHoteles {

	private static final Logger logger = LogManager.getLogger(Hotel_repository.class);

	public static void main(String[] args) {

		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db = conexion.getDb();
		Hotel_repository repository = new Hotel_repository(db);
		Hotel_service service = new Hotel_service(repository);
		
		List<Habitacion> misHabitaciones = new ArrayList<>();

		// Añadimos habitaciones usando el constructor (Tipo, Precio, Capacidad, Disponible)
		misHabitaciones.add(new Habitacion(Tipo.SUITE_JUNIOR, 200.50, 2, true));
		misHabitaciones.add(new Habitacion(Tipo.DOBLE_ESTANDAR, 120.0, 2, false));
		misHabitaciones.add(new Habitacion(Tipo.INDIVIDUAL, 65.0, 1, true));
		
		Coordenadas misCoordenadas = new Coordenadas(37.3891, -5.9845);
		
		Ubicacion miUbicacion = new Ubicacion("Avenida de la Constitución", 15, "41004", misCoordenadas);

		Hotel nuevoHotel = new Hotel("h999", "Hotel Constructor Java", 5, true, "2024-01-01", miUbicacion, misHabitaciones);

		List<Hotel> hotels = service.read();
		logger.info(service.filtradoPorId("h101"));

		service.update(nuevoHotel, "h101");

//		for(Hotel hotel: hotels) {
//			logger.info(hotel);
//		}
	}

}
