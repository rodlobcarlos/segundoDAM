package boletin3_ejecicio1;

import java.util.HashSet;
import java.util.Set;

public class Libreria {

	private Set<Libro> listaLibros;

	public Libreria() {
		super();
		this.listaLibros = new HashSet<Libro>();
	}

	@Override
	public String toString() {
		return "Libreria [listaLibros=" + listaLibros + "]";
	}

	public Set<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(Set<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	
}
