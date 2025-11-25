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
		
		Estudiante estudiante2 = new Estudiante(22, "Maria Peláez", 7.78, List.of("leer", "nadar"));
		estudiante.save(estudiante2);
		List<Estudiante> estudiantes = estudiante.read();
		for(Estudiante e: estudiantes) {
			System.out.println(e);
		}
//TODO Aquí creamos los diferentes servicios a partir del objeto db	
	}

}
