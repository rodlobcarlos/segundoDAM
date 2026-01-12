package pokemon_controller;

import utiles.UtilidadesJsonPokemon;
import utiles.UtilidadesPokemonCSV;

public class GetionaPokemon {

	private static final String resource = "src\\main\\resources\\pokemon.json";
	private static final String rutaCSV = "src\\main\\resources\\pokemons.csv";
	private static final String rutaCSV2 = "src\\main\\resources\\listaPokemon.csv";


	public static void main(String[] args) {

		UtilidadesJsonPokemon jsonPokemon = new UtilidadesJsonPokemon();
		jsonPokemon.leePokemons(resource);

		UtilidadesPokemonCSV pokemonCSV = new UtilidadesPokemonCSV();
		pokemonCSV.escrituraCsv(rutaCSV);
		
		pokemonCSV.leeCsv(rutaCSV);
	}

}
