package repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.LibreriaException;
import model.Libros;

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
<<<<<<< Updated upstream
		if (libros.contains(libro)) {
=======
		if(libros.contains(libro)) {
>>>>>>> Stashed changes
			System.out.println("El libro ya está añadido.");
		} else {
			libros.add(libro);
<<<<<<< Updated upstream
			System.out.println("Libro añadido: " + libro);
=======
			System.out.println("Libro añadido: " + libro);		
>>>>>>> Stashed changes
		}
	}

	public boolean actualizarLibro(Libros libro) throws LibreriaException {
<<<<<<< Updated upstream
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
=======
		Libros p1 = leerLibro(libro.getISBN());
		libros.remove(p1);
		libros.add(libro);
		boolean esActualizado = true;
		if(p1 == null) {
			esActualizado = false;
			throw new LibreriaException("Este libro ya existe.");
		}
		return esActualizado;
	}
	
	public void eliminarLibro(Libros libro) throws LibreriaException {
		Libros p2 = leerLibro(libro.getISBN());
		libros.remove(p2);
		boolean esEliminado = true;
		if(p2 == null) {
			throw new LibreriaException("Este libro ya existe.");
		}
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

=======
	
>>>>>>> Stashed changes
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
