package simulacroMongoDB_service;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.model.Updates;

import simulacroMongoDB_model.Hotel;
import simulacroMongoDB_model.SimulacionException;
import simulacroMongoDB_repository.Hotel_repository;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static com.mongodb.client.model.Aggregates.*; // Necesario para el ejercicio 7
import static com.mongodb.client.model.Accumulators.*; // Necesario para el ejercicio 7

public class Hotel_service {

	private Hotel_repository repo;
	private static final Logger logger = LogManager.getLogger(Hotel_repository.class);

	public Hotel_repository getRepo() {
		return repo;
	}

	public void setRepo(Hotel_repository repo) {
		this.repo = repo;
	}

	public static Logger getLogger() {
		return logger;
	}

	public Hotel_service(Hotel_repository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "Hotel_service [repo=" + repo + "]";
	}

	public void save(Hotel h) {
		repo.save(h);
	}

	public List<Hotel> read() {
		return repo.read();
	}

	public void delete(Hotel h) {
		try {
			repo.delete(h);
		} catch (SimulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Hotel h, String id) {
		try {
			repo.update(h, id);
		} catch (SimulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Hotel filtradoPorId(String id) {
		return repo.getHotelesFiltradosPorId(id);
	}

	public void recuperarHoteles() {
		repo.getColeccion().find(and(regex("ubicacion.codigoPostal", "^28"), // Filtro para Madrid (empieza por 28)
				or(eq("estrellas", 5), eq("admiteMascotas", true))));
	}

	public void numeroTotalHoteles() {
		repo.getColeccion().countDocuments(eq("habitaciones.tipo", "Suite Junior"));
	}

	public void añadiHabitacion(String idHotel) {
		Document nuevaHabitacion = new Document("tipo", "Penthouse").append("precio", 500.00).append("capacidad", 4)
				.append("disponible", true);

		repo.getColeccion().updateOne(eq("idHotel", idHotel), Updates.push("habitaciones", nuevaHabitacion));
	}

	public void actualizarCodigoPostal() {
		repo.getColeccion().updateMany(eq("ubicacion.calle", "Gran Vía"), set("ubicacion.codigoPostal", "28013"));
	}

	public void actualizarPrecio() {
		repo.getColeccion().updateOne(and(eq("idHotel", "h101"), eq("habitaciones.tipo", "Individual")),
				set("habitaciones.$.precio", 90.00));
	}

	public void eliminarPorPrecio() {
		repo.getColeccion().updateOne(eq("nombre", "Grand Hotel Central"), pull("habitaciones", gt("precio", 300.00)));
	}

	public void mediaEstrellas() {
		repo.getColeccion().aggregate(Arrays.asList(match(regex("ubicacion.codigoPostal", "^08")),
				group(null, avg("mediaEstrellas", "$estrellas"))));
	}
}
