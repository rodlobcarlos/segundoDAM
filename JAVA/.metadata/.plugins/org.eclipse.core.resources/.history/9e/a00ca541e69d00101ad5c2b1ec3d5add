package service;

import java.util.HashSet;
import java.util.Set;

import model.Editorial;
import model.GeneroLibro;
import model.LibreriaException;
import model.Libros;
import repository.LibrosRepository;

public class LibrosServicio {

	private LibrosRepository libroRep;

	public LibrosServicio(LibrosRepository libroRep) {
		super();
		this.libroRep = new LibrosRepository();
	}

	public LibrosRepository getLibroRep() {
		return libroRep;
	}

	public void setLibroRep(LibrosRepository libroRep) {
		this.libroRep = libroRep;
	}

	public void actualizarLibro(Libros l) {
		try {
			this.libroRep.actualizarLibro(l);
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}
	}

	public void consultarLibro(Libros l) {
		try {
			this.libroRep.consultarLibros(l);
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}
	}

	public void eliminarLibro(Libros l) {
		try {
			this.libroRep.eliminarLibro(l);
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void añadirLibro(Libros l) {
		this.libroRep.añadirLibro(l);
	}
	
	public Set<Libros> genero(GeneroLibro genLibro) {
		Set<Libros> libro = new HashSet<Libros>();
		for(Libros l: libro) {
			if(l.getGenero().equals(genLibro)) {
				libro.add(l);
			}
		}
		return libro;
	}
	
	public Set<Libros> cif(Editorial cif) {
		Set<Libros> libro = new HashSet<Libros>();
		for(Libros l : libro) {
			if(l.getEditorial().getCif().equals(cif)) {
				libro.add(l);
			}
		}
		return libro;
	}
	
}
