package utiles;

import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import pokemon_model.Pokemon;

public class UtilidadesJsonPokemon {

	private static final Logger logger = LogManager.getLogger(UtilidadesJsonPokemon.class);

	// lectura de json, que retorna un objeto pokemon
	public Pokemon leePokemons(String rutaFichero) {
		try {
			Gson gson = new Gson();
			FileReader fichero = new FileReader(rutaFichero);
			Pokemon pokemons = gson.fromJson(fichero, Pokemon.class);
			logger.debug("Pokemon leído: " + pokemons);
			fichero.close();
			return pokemons;
		} catch (Exception e) {
			logger.info("Error al leer pokemon" + e.getMessage());
			return null;
		}
	}

}
