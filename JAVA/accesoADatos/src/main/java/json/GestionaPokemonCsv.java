package json;

public class GestionaPokemonCsv {

	public static void main(String[] args) {
//		UtilidadesJsonPokemons ut = new UtilidadesJsonPokemons();
//		ut.leePokemon("src\\main\\resources\\pokemon.json");
		UtilidadesPokemonCsv csv = new UtilidadesPokemonCsv();
//		csv.escrituraCsv("src\\main\\resources\\pokemon.json");
		csv.leeCsv("src\\main\\resources\\pokemon.csv");
	}
}
