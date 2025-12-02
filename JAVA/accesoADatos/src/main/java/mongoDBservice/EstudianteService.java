package mongoDBservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import mongoDBconfig.MongoDBConexion;
import mongoDBmodel.Estudiante;
import mongoDBmodel.Scores;
import mongoDBrepository.EstudianteRepository;

public class EstudianteService {

	private final EstudianteRepository repo;
	private static final Logger logger = LogManager.getLogger(MongoDBConexion.class);


	// El servicio recibe MongoDatabase y construye el repositorio
	public EstudianteService(MongoDatabase db) {
		this.repo = new EstudianteRepository(db);
	}

	// Guarda un estudiante en la base de datos
	public void save(Estudiante e) {
		// Aquí podrías añadir validaciones, reglas de negocio, etc.
		repo.save(e);
	}

	// Lista todos los estudiantes
	public List<Estudiante> read() {
		return repo.read();
	}
	// TODO Agregar resto de operaciones del CRUD
	
	public void delete(Estudiante estudiante) {
		repo.delete(estudiante);
	}
	
	public void update(Estudiante estudiante) {
		repo.update(estudiante);
	}
	
	public List<Estudiante> notaMediaInferiorACinco(List<Estudiante> e) {
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		for(Estudiante estudiante: e) {
			if(estudiante.getNotaMedia() < 5) {
				estudiantes.add(estudiante);
			}
		}
		return estudiantes;
	}
	
	public List<Estudiante> ciudad(String ciudad) {
		List<Estudiante> e = new ArrayList<Estudiante>();
		for(Estudiante document: repo.getEstudiantes()) {
			if (document.getAddresses().getCity().equals(ciudad)) {
				e.add(document);
			}
		}
		return e;		
	}
	
	public void mediaScores(List<Estudiante> e) {
		double media = 0;
		for(Estudiante a: e) {
			List<Scores> scores = a.getScores();
			int contador = 0;
			for(Scores scores2: scores) {
				contador += scores2.getScore();
				 media = contador / scores.size();
			}
			 logger.info(a.getName() + " media" + media);
		}
	}
}
