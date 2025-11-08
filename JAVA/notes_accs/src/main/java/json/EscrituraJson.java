package json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class EscrituraJson {

	public static void main(String[] args) {

		EscrituraJson ej = new EscrituraJson();
		Marvel m1 = new Marvel("Thor", "Marvel Comics", "Thor Odinson", "Journey into Myster #83", "Thor Odinson");
		Marvel m2 = new Marvel("Wonder Woman", "DC Comics", "Princess Diana", "All Star Comics #8", "Princess Diana");
		Marvel m3 = new Marvel("Daredevil", "Marvel Comics", "Matthew Michael Murdock", "Daredevil #1", "Matthew Michael Murdock");
		List<Marvel> lista = new ArrayList<Marvel>();
		lista.add(m1);
		lista.add(m2);
		lista.add(m3);
		ej.escribeEmpleado(m1, "src\\main\\resources\\objeto_json.json");
		ej.escribeEmpleados(lista, "src\\main\\resources\\objetoLista_json.json");

	}

	// Escritura de fichero Objeto a JSON
	public void escribeEmpleado(Marvel personaje, String ruta) {// Convertir el objeto a JSON
		Gson gson = new Gson();
		String json = gson.toJson(personaje);
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(ruta);
			fichero.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println("Error al escribir empleado");
				}
			}
		}
	}

	// Escritura de fichero Objeto(lista) a JSON
	public void escribeEmpleados(List<Marvel> listaPersonajes, String ruta) {
		Gson gson = new Gson();
		String json = gson.toJson(listaPersonajes); // Escribir el JSON en un archivo

		FileWriter writer = null;
		try {
			writer = new FileWriter(ruta);
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
