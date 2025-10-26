package tema1;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Persona {

	private String nombre;
	private List<Notas> listaNotas;
	
	private static final Logger logger = LogManager.getLogger(Persona.class);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Notas> getListaPersonas() {
		return listaNotas;
	}

	public void setListaPersonas(List<Notas> listaNotas) {
		this.listaNotas = listaNotas;
	}

	public Persona(String nombre, List<Notas> listaNotas) {
		super();
		this.nombre = nombre;
		this.listaNotas = listaNotas;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", listaNotas=" + listaNotas + "]";
	}
	
}
