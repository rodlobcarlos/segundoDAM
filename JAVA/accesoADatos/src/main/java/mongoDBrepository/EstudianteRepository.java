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
import mongoDBmodel.Score;

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
		Score s = new Score();
		Address a = new Address();
		Document docScores = new Document("scores", e.getScores())
				.append("type", s.getType());
		coleccion.insertOne(docScores);
		
		Document docAddress = new Document("adress", a.getCity())
				.append("city", a.getCity())
				.append("zip", a.getZip())
				.append("street", a.getStreet())
				.append("number", a.getNumber());
		coleccion.insertOne(docAddress);
		
		Document doc = new Document("id", e.getId())
				.append("name", e.getName())
				.append("notaMedia", e.getNotaMedia())
				.append("aficiones", e.getAficiones());
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
			List<String> scores = doc.getList("scores", .class);
			List<String> address = doc.getList("address", String.class);
			List<String> aficiones = doc.getList("aficiones", String.class);
			e.setScores(scores != null ? scores : new ArrayList<>());
			e.setAddresses(address != null ? address : new ArrayList<>());
			e.setAficiones(aficiones != null ? aficiones : new ArrayList<>());
			estudiantes.add(e);
		}
		return estudiantes;
	}
	
	public Estudiante delete(Estudiante e) {
		if(estudiantes.contains(e)) {
			estudiantes.remove(e);
			logger.info("Borrado" + e);
		}else {
			logger.info("No existe este estudiante.");
		}
		return e;
	}
}
