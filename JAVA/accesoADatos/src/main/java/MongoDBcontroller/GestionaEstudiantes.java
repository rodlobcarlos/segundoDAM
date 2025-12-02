package MongoDBcontroller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import mongoDBconfig.MongoDBConexion;
import mongoDBmodel.Estudiante;
import mongoDBservice.EstudianteService;

public class GestionaEstudiantes {
	
	private static final Logger logger = LogManager.getLogger(MongoDBConexion.class);

	public static void main(String[] args) {

		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db = conexion.getDb();
		EstudianteService estudiante = new EstudianteService(db);
//		estudiante.read();
		List<Estudiante> estudiantes = estudiante.read();
		logger.debug(estudiante.notaMediaInferiorACinco(estudiantes));
		logger.debug(estudiante.ciudad("BRONX"));
		estudiante.mediaScores(estudiantes);
//		estudiante.notaInferiorAcinco(estudiantes);
//		for (Estudiante e : estudiantes) {
//			System.out.println(e);
//		}
//TODO Aquí creamos los diferentes servicios a partir del objeto db	
	}
}
