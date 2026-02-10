package rodriguezCarlosParte1Hibernate_servicio;

import dao.CineDao;
import dao.PeliculaDao;
import dao.SalaDao;
import rodriguezCarlosParte1Hibernate_modelo.Cine;
import rodriguezCarlosParte1Hibernate_modelo.Pelicula;
import rodriguezCarlosParte1Hibernate_modelo.Sala;

public class Servicio {

	private CineDao cineDao;
	private SalaDao salaDao;
	private PeliculaDao peliculaDao;

	public Servicio() {
		super();
		this.cineDao = new CineDao();
		this.salaDao = new SalaDao();
		this.peliculaDao = new PeliculaDao();
	}
	
	public void addCine(Cine cine) {
		cineDao.create(cine);
	}
	
	public void addSala(Sala sala) {
		salaDao.create(sala);
	}

	public void addPelicula(Pelicula pelicula) {
		peliculaDao.create(pelicula);
	}
}
