package escrituraFichero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ficheros1 {

	public static void main(String[] args) {
		Ficheros1 f1 = new Ficheros1();
		f1.escriturafichero("src\\main\\resources\\escritura.txt");
	}

	public void escriturafichero(String rutaFichero) {
		PrintWriter out = null;
		
		try {
			FileWriter fichero;
			fichero = new FileWriter(rutaFichero); // abre el fichero de texto
			out = new PrintWriter(fichero);// escribe el listado persona a persona
			List<Persona> personas = new ArrayList<Persona>(); 
			personas.add(new Persona("Carlos", 20));
			for(Persona p: personas) {
				out.printf("nombre: %s, edad: %d%n",
						p.getNombre(),
						p.getEdad()
						);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(out != null) {
				out.close();
			}
		}
	}
}
