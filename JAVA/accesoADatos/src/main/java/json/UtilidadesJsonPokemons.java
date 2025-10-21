package json;

import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tema1.DiffFolder;
import com.google.gson.Gson;

public class UtilidadesJsonPokemons {
	private static final Logger logger = LogManager.getLogger(DiffFolder.class);

	public Pokemon leePokemon(String rutaFichero) {
	    try {
	        Gson gson = new Gson();
	        FileReader fichero = new FileReader(rutaFichero);
	        Pokemon pokemon = gson.fromJson(fichero, Pokemon.class);

	        logger.debug("Pokemon leído: " + pokemon);
	        fichero.close();
	        return pokemon;

	    } catch (Exception e) {
	        logger.error("Error al leer el archivo JSON", e);
	        return null;
	    }
	}

}
