package MongoDBcontroller;

import java.util.List;

import com.mongodb.client.MongoDatabase;

import mongoDBconfig.MongoDBConexion;
import mongoDBmodel.Estudiante;
import mongoDBservice.EstudianteService;

public class GestionaPeliculasbd {

	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db = conexion.getDb();
		EstudianteService estudiante = new EstudianteService(db);
		
		List<Estudiante> estudiantes = estudiante.read();
		Estudiante estudiante2 = new Estudiante(22, "Maria Peláez", 7.78, List.of("leer", "nadar"), null, null);
		estudiante.save(estudiante2);
//		estudiante.notaInferiorAcinco(estudiantes);
		estudiante.delete(estudiante2);

		for(Estudiante e: estudiantes) {
			System.out.println(e);
		}
//TODO Aquí creamos los diferentes servicios a partir del objeto db	
	}
}
