package ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Escritura {

	public static void main(String[] args) {

		Escritura e = new Escritura();
		List<PersonaF> personas = new ArrayList<PersonaF>();
		personas.add(
				new PersonaF("Hola", "adios", 54));
		e.escribePersonas(personas, "src\\main\\resources\\escrituraPersonaF.txt");
	}

	public void escribePersonas(List<PersonaF> personas, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (PersonaF p : personas) {
				out.printf("Dni %s; Apellidos %s; Edad; %d", 
						p.getDni(), 
						p.getApellidos(), 
						p.getEdad()
						);
			}
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}

}
