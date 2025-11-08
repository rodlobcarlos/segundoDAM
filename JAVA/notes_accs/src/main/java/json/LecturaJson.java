package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import metodos.CrearFicheros_Directorios;

public class LecturaJson {
	
	private static final Logger logger = LogManager.getLogger(CrearFicheros_Directorios.class);


	public static void main(String[] args) {

		LecturaJson lj = new LecturaJson();
		lj.leerJson("src\\main\\resources\\maverl.json");
		lj.leerListaPersonajes("src\\main\\resources\\listaMarvel.json");
	}
	
	// Leer fichero JSON
	public void leerJson(String rutaFichero) {
		Gson gson = new Gson();
		try {
			FileReader fichero = new FileReader(rutaFichero);
			Marvel personaje = gson.fromJson(fichero, Marvel.class);
			logger.debug(personaje);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Leer fichero JSON (lista)
	public void leerListaPersonajes(String rutaFichero) {
		try {
		  Gson gson = new Gson();
		  FileReader fichero = new FileReader(rutaFichero);
		  // Leer el archivo JSON y convertirlo a un objeto X
		  Marvel[] personajeArray = gson.fromJson(fichero,Marvel[].class);
			List<Marvel> personajes = Arrays.asList(personajeArray);
			logger.debug(personajes);
		} catch (Exception e) {
			System.out.println("Error al leer empleados"+e.getMessage());
		}	}

}
