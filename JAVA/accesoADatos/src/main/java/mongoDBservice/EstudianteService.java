package mongoDBservice;

import java.util.List;

import com.mongodb.client.MongoDatabase;

import mongoDBmodel.Estudiante;
import mongoDBrepository.EstudianteRepository;

public class EstudianteService {

	private final EstudianteRepository repo;

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

}
