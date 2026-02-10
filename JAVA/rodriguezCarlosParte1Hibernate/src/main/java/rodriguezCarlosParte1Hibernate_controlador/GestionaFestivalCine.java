package rodriguezCarlosParte1Hibernate_controlador;

import java.util.ArrayList;
import java.util.List;

import rodriguezCarlosParte1Hibernate_modelo.Cine;
import rodriguezCarlosParte1Hibernate_modelo.Pelicula;
import rodriguezCarlosParte1Hibernate_modelo.Sala;
import rodriguezCarlosParte1Hibernate_servicio.Servicio;

public class GestionaFestivalCine {

	public static void main(String[] args) {

		Servicio servicio = new Servicio();

		List<Sala> salas = new ArrayList<Sala>();
		Sala sala1 = new Sala("Sala A", 30);
		Sala sala2 = new Sala("Sala B", 50);
		Sala sala3 = new Sala("Sala C", 100);
		Sala sala4 = new Sala("Sala D", 76);
		
		salas.add(sala4);
		salas.add(sala3);
		salas.add(sala2);
		salas.add(sala1);

		Pelicula pelicula1 = new Pelicula("Misión imposible", "Drama", 120);
		Pelicula pelicula2 = new Pelicula("Cars", "Animación", 111);
		Pelicula pelicula3 = new Pelicula("Avatar", "Acción/Violencia", 133);

		sala1.addPelicula(pelicula1);
		sala2.addPelicula(pelicula3);
		sala3.addPelicula(pelicula2);
		sala4.addPelicula(pelicula3);

		Cine cine1 = new Cine("Cine Yelmo", "Lagho");
		servicio.addCine(cine1);
		Cine cine2 = new Cine("Odeon cinema", "Plaza de armas");
		servicio.addCine(cine2);

		List<Pelicula> peliculas1 = new ArrayList<Pelicula>();
		List<Pelicula> peliculas2 = new ArrayList<Pelicula>();
		List<Pelicula> peliculas3 = new ArrayList<Pelicula>();

		peliculas1.add(pelicula1);
		peliculas2.add(pelicula2);
		peliculas1.add(pelicula3);

		servicio.addPelicula(pelicula1);
		servicio.addPelicula(pelicula2);
		servicio.addPelicula(pelicula1);

	}

}
