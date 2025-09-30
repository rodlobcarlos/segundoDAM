package repository.libreria;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.libreria.LibreriaException;
import model.libreria.Libros;

public class LibrosRepository {

	private Set<Libros> libros;

	public Set<Libros> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libros> libros) {
		this.libros = libros;
	}

	public LibrosRepository() {
		super();
		this.libros = new HashSet<Libros>();
	}

	public void añadirLibro(Libros libro) {
		if(libros.contains(libro)) {
			System.out.println("El libro ya está añadido.");
		} else {
			libros.add(libro);
			System.out.println("Libro añadido: " + libro);
		}
	}

	public boolean actualizarLibro(Libros libro) throws LibreriaException {
		boolean esActualizado = false;
		if (libros.contains(libro)) {
			Libros p1 = leerLibro(libro.getISBN());
			libros.remove(p1);
			libros.add(libro);
			esActualizado = true;
		} else {
			throw new LibreriaException("Este libro no existe.");
		}
		return esActualizado;
	}

	public boolean eliminarLibro(Libros libro) throws LibreriaException {
		boolean esEliminado = false;
		if(libros.contains(libro)) {
			libros.remove(libro);
			 esEliminado = true;
		} else {
			throw new LibreriaException("Este libro no exise.");
		}
		return esEliminado;
	}

	public void consultarLibros(Libros libro) throws LibreriaException {
		boolean esConsultado = false;
		if (libros.contains(libro)) {
			System.out.println(libro.toString());
			esConsultado = true;
		} else {
			throw new LibreriaException("Este libro no exise.");
		}
	}

	public Libros leerLibro(String ISBN) throws LibreriaException {
		Libros libro1 = null;
		boolean encontrado = false;
		Iterator<Libros> l = libros.iterator();
		while (!encontrado && l.hasNext()) {
			Libros libro2 = l.next();
			if (libro2.getISBN().equals(ISBN)) {
				libro1 = libro2;
				encontrado = true;
			} else {
				throw new LibreriaException("Este libro no exise.");
			}
		}
		return libro1;
	}
}
