package controller.libreria;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import model.libreria.GeneroLibro;
import model.libreria.LibreriaException;
import model.libreria.Libros;
import repository.libreria.LibrosRepository;


public class GestionLibreria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libros l1 = new Libros("ASD435G4F2H6J", "El caballero oscuro", "Federico", LocalDate.of(2025, 04, 20), GeneroLibro.HISTORICO, "Editoial primera", 20);
		Libros l2 = new Libros("ASF34HJK56LM7", "El mago", "Marcos", LocalDate.of(2024, 02, 12), GeneroLibro.INFANTIL, "Editorial segunda", 15);
		Libros l3 = new Libros("ADFE5433234FG", "El CABALELRO", "Maria", LocalDate.of(2025, 05, 24), GeneroLibro.HISTORICO, "Editorial tercera", 50);


		Set<Libros> libros = new HashSet<Libros>();
		LibrosRepository rep = new LibrosRepository();
		
		libros.add(l2);
		libros.add(l1);
		System.out.println(libros);
		
		rep.añadirLibro(l2);
		rep.añadirLibro(l1);
		rep.añadirLibro(l2); // Repetido
		rep.añadirLibro(l3);
		
		try {
			rep.leerLibro("ASD435G4F2H6J");
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			rep.leerLibro("ASF34HJK56LM7");
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(rep.actualizarLibro(l2));
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			rep.consultarLibros(l2);
		} catch (LibreriaException e) {
			System.out.println(e.getMessage());
		}
	}
}
