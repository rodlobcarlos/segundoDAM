package simulacroMongoDB_repository;

import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import simulacroMongoDB_model.Coordenadas;
import simulacroMongoDB_model.Habitacion;
import simulacroMongoDB_model.Hotel;
import simulacroMongoDB_model.SimulacionException;
import simulacroMongoDB_model.Tipo;
import simulacroMongoDB_model.Ubicacion;

public class Hotel_repository {

	private List<Hotel> hoteles;
	private static final String NOMBRE_COLECCION = "hoteles";
	private final MongoCollection<Document> coleccion;
	private static final Logger logger = LogManager.getLogger(Hotel_repository.class);

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}

	public static String getNombreColeccion() {
		return NOMBRE_COLECCION;
	}

	public MongoCollection<Document> getColeccion() {
		return coleccion;
	}

	public static Logger getLogger() {
		return logger;
	}

	public Hotel_repository(MongoDatabase db) {
		super();
		this.coleccion = db.getCollection(NOMBRE_COLECCION);
		this.hoteles = this.read();
	}

	private Hotel fromDocumentoHotel2Java(Document doc) {
		Hotel h = new Hotel();
		h.setIdHotel(doc.getString("idHotel"));
		h.setNombre(doc.getString("nombre"));
		h.setEstrellas(doc.getInteger("estrellas", 0));
		h.setAdmiteMascotas(doc.getBoolean("admiteMascotas", false));
		h.setFechaApertura(doc.getString("fechaApertura"));

		Document docUbicacion = (Document) doc.get("ubicacion");
		Ubicacion u = new Ubicacion();
		u.setCalle(docUbicacion.getString("calle"));
		u.setNumero(docUbicacion.getInteger("numero", 0));
		u.setCodigoPostal(docUbicacion.getString("codigoPostal"));
		h.setUbicacion(u);

		Document docCoordenadas = (Document) docUbicacion.get("coordenadas");
		Coordenadas c = new Coordenadas();
		c.setLat(docCoordenadas.getDouble("lat"));
		c.setLon(docCoordenadas.get("lon", Number.class).doubleValue());
		u.setCoordenadas(c);

		List<Document> listaDocHabitaciones = doc.getList("habitaciones", Document.class);
		List<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		for (Document document : listaDocHabitaciones) {
			Habitacion a = new Habitacion();
			a.setTipo(Tipo.valueOf(document.getString("tipo")));
			a.setPrecio(document.get("precio", Number.class).doubleValue());
			a.setCapacidad(document.getInteger("capacidad", 0));
			a.setDiponible(document.getBoolean("disponible", false));
			listaHabitaciones.add(a);
		}
		h.setHabitaciones(listaHabitaciones);
		return h;
	}

	private Document fromHotelDocumentoJava(Hotel h) {
		Document docHotel = new Document("idHotel", h.getIdHotel()).append("nombre", h.getNombre())
				.append("estrellas", h.getEstrellas()).append("admiteMascotas", h.isAdmiteMascotas())
				.append("fechaApertura", h.getFechaApertura()).append("ubicacion", h.getUbicacion())
				.append("habitaciones", h.getHabitaciones());

		Ubicacion u = new Ubicacion();
		Document docUbicacion = new Document("ubicacion", u.getCalle()).append("numero", u.getNumero())
				.append("codigoPostal", u.getCodigoPostal()).append("coordenadas", u.getCoordenadas());

		Coordenadas c = new Coordenadas();
		Document docCoordenada = new Document("lat", c.getLat()).append("lon", c.getLon());

		List<Document> habitaciones = new ArrayList<Document>();
		for (Habitacion habitacion : h.getHabitaciones()) {
			Document docHabitacion = new Document("tipo", habitacion.getTipo()).append("precio", habitacion.getPrecio())
					.append("capacidad", habitacion.getCapacidad()).append("disponible", habitacion.isDiponible());
			habitaciones.add(docHotel);
		}
		return docHotel;
	}

	public void save(Hotel h) {
		coleccion.insertOne(fromHotelDocumentoJava(h));
	}

	public List<Hotel> read() {
		List<Hotel> hotel = new ArrayList<>();
		FindIterable<Document> documentos = coleccion.find();
		for (Document document : documentos) {
			Hotel h = fromDocumentoHotel2Java(document);
			hotel.add(h);
		}
		return hotel;
	}

	public void delete(Hotel h) throws SimulacionException {
		if (hoteles.contains(h)) {
			Document user = fromHotelDocumentoJava(h);
			coleccion.deleteOne(user);
		} else {
			throw new SimulacionException("Este hotel no existe.");
		}
	}

	public UpdateResult update(Hotel h, String id) throws SimulacionException {
		Document filtro = new Document("idHotel", id); // Con el json del filtro
		Document usuarioHotel = fromHotelDocumentoJava(h);
		UpdateResult resultado = coleccion.replaceOne(filtro, usuarioHotel);
		if (resultado.getMatchedCount() == 0) {
			throw new SimulacionException("No hay hotel por ese id.");
		}
		return resultado;
	}

	public Hotel getHotelesFiltradosPorId(String id) {
		Document filtro = new Document("idHotel", id); // Con el json del filtro
		Document resultado = this.coleccion.find(filtro).first();
		Hotel u = fromDocumentoHotel2Java(resultado);
		return u;
	}
}
