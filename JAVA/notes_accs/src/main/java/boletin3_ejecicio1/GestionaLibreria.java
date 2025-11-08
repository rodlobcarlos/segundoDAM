package boletin3_ejecicio1;

import java.util.HashSet;
import java.util.Set;

public class GestionaLibreria {

	public static void main(String[] args) {

		Libreria libreria = new Libreria();
		Libro l1 = new Libro("AUTOR1", "Pérez","as23asd", "LIBRO1", "animales", "cogeLibros");
		Libro l2 = new Libro("AUTOR2", "Carmona", "324asf", "LIBRO2", "fantasia", "compraLibros");
		Libro l3 = new Libro("AUTOR3", "García", "gj345", "LIBRO3", "oscuro", "vendeLibros");
		Libro l4 = new Libro("AUTOR4", "Gutierrez", "mbcxw43534", "LIBRO4", "magia", "holaLibros");
		Libro l5 = new Libro("AUTOR5", "Rodríguez", "987dfgd", "LIBRO5", "misterio", "tuLibros");

		Set<Libro> listaLibros = new HashSet<Libro>();
		listaLibros.add(l1);
		listaLibros.add(l2);
		listaLibros.add(l3);
		listaLibros.add(l4);
		listaLibros.add(l5);

		ManejoTxtLibreria manejo = new ManejoTxtLibreria();
		manejo.escrituraFichero(listaLibros, "src\\main\\resources\\libros.txt");
	}

}
