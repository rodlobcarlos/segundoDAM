package json;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UtilidadesPokemonCsv {

	public void escrituraCsv(String fichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(fichero);
			out = new PrintWriter(ficheroSalida);
			out.printf("id,nombre,tipo,altura_m,peso_kg,habilidades,evoluciona_a\r\n"
					+ "1,Bulbasaur,\"Planta;Veneno\",0.7,6.9,\"Espesura;Clorofila\",Ivysaur\r\n"
					+ "");
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}

}
