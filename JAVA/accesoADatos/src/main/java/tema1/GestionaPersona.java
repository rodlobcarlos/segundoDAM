package tema1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utiles.ManejaFicheroPersona;

public class GestionaPersona {
	private static final Logger logger = LogManager.getLogger(GestionaPersona.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Notas> listaNotas = new ArrayList<Notas>();
		ManejaFicheroPersona p = new ManejaFicheroPersona();
		
		try {
			p.cargarLista(
					"C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\java\\tema1\\fichero1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
