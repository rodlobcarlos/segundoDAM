package mongoDBrepository;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.db.DbAppenderLoggingException;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mongoDBconfig.MongoDBConexion;
import mongoDBmodel.Address;
import mongoDBmodel.Estudiante;
import mongoDBmodel.Scores;

public class EstudianteRepository {

	private static final String NOMBRE_COLECCION = "estudiantes";
	private final MongoCollection<Document> coleccion;
	private List<Estudiante> estudiantes;
	private static final Logger logger = LogManager.getLogger(MongoDBConexion.class);

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public static String getNombreColeccion() {
		return NOMBRE_COLECCION;
	}

	public MongoCollection<Document> getColeccion() {
		return coleccion;
	}

	public EstudianteRepository(MongoDatabase db) {
		this.coleccion = db.getCollection(NOMBRE_COLECCION);
		this.estudiantes = this.read();
	}

	public void save(Estudiante e) {
		Scores s = new Scores();
		Address a = new Address();
		List<Document> scores = new ArrayList<Document>();
		for (Scores score : e.getScores()) {
			Document docScores = new Document("scores", e.getScores()).append("type", s.getType());
			scores.add(docScores);
		}

		Document docAddress = new Document("adress", a.getCity()).append("city", a.getCity()).append("zip", a.getZip())
				.append("street", a.getStreet()).append("number", a.getNumber());

		Document doc = new Document("id", e.getId()).append("name", e.getName()).append("notaMedia", e.getNotaMedia())
				.append("aficiones", e.getAficiones()).append("address", docAddress).append("scores", e.getScores());
		coleccion.insertOne(doc);
	}

	public List<Estudiante> read() {
		List<Estudiante> estudiantes = new ArrayList<>();
		FindIterable<Document> documentos = coleccion.find();
		for (Document doc : documentos) {
			Estudiante e = new Estudiante();
			e.setId(doc.getInteger("id", 0));
			e.setName(doc.getString("name"));
			e.setNotaMedia(doc.getDouble("notaMedia"));
			List<String> aficiones = doc.getList("aficiones", String.class);
			e.setAficiones(aficiones != null ? aficiones : new ArrayList<>());

			Document docAddress = (Document) doc.get("address");
			Address address = new Address();
			address.setCity(docAddress.getString("city"));
			address.setZip(docAddress.getInteger("zip", 0));
			address.setStreet(docAddress.getString("street"));
			address.setNumber(docAddress.getInteger("number", 0));
			e.setAddresses(address);
			
			List<Document> docScores = (List<Document>) doc.get("scores");
			List<Scores> scores = new ArrayList<Scores>();
			for(Document document: docScores) {
				Scores score = new Scores();
				score.setScore(document.getDouble("score"));
				score.setType(document.getString("type"));
				scores.add(score);
			}			
			e.setScores(scores);
			estudiantes.add(e);
		}
		return estudiantes;
	}

	public Estudiante delete(Estudiante e) {
		if (estudiantes.contains(e)) {
			estudiantes.remove(e);
			logger.info("Borrado" + e);
		} else {
			logger.info("No existe este estudiante.");
		}
		return e;
	}
	
	public void update(Estudiante e) {
		Estudiante estudiante = new Estudiante();
		if(estudiantes.contains(e)) {
			estudiantes.remove(e);
			estudiantes.add(estudiante);
		}else {
			logger.info("El estudiante no existe.");
		}
	}
}
