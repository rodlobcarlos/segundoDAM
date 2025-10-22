package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.NumberOfInterveningJobs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

public class UtilidadesPokemonCsv {

	private static final Logger logger = LogManager.getLogger(UtilidadesJsonPokemons.class);

	public void escrituraCsv(String fichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(fichero);
			out = new PrintWriter(ficheroSalida);
			out.printf("id,nombre,tipo,altura_m,peso_kg,habilidades,evoluciona_a\r\n"
					+ "1,Bulbasaur,\"Planta;Veneno\",0.7,6.9,\"Espesura;Clorofila\",Ivysaur\r\n" + "");
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}

	public List<Pokemon> leeCsv(String f) {
		List<Pokemon> listaPokemons = new ArrayList<Pokemon>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(f);
			in = new Scanner(fichero);
			in.hasNextLine();
			while (in.hasNextLine()) {
				String linea = in.nextLine();
				String[] p = linea.split(",");
				int id = Integer.parseInt(p[0]);
				String nombre = p[1];
				String tipo = p[2];
				float altura_m = Float.parseFloat(p[3]);
				float peso_kg = Float.parseFloat(p[4]);
				String[] habilidadPrincipal = p[5].split(";");
				String evoluciona_a = p[6];
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return listaPokemons;
	}
}