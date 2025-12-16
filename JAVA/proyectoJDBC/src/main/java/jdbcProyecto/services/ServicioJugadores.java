package jdbcProyecto.services;

import exceptions.MiExcepcion;
import jdbcProyecto.models.Jugador;
import jdbcProyecto.repositories.RepositorioJugadores;

public class ServicioJugadores {

	private RepositorioJugadores repo;

	public ServicioJugadores() throws MiExcepcion {
		super();
		this.repo = new RepositorioJugadores();
	}

	@Override
	public String toString() {
		return "ServicioJugadores [repo=" + repo + "]";
	}

	public RepositorioJugadores getRepo() {
		return repo;
	}

	public void setRepo(RepositorioJugadores repo) {
		this.repo = repo;
	}
	
	public void altaJugador(Jugador jugador) {
		repo.altaJugador(jugador);
	}
	
	public void obtenerJugadorMayorPuntuacion() {
		try {
			repo.obtenerJugadorMayorPuntuacion();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarJugadoresOrdenadosPorPuntos() { 
		try {
			repo.mostrarJugadoresOrdenadosPorPuntos();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrarJugador(int id) {
		repo.borrarJugador(id);
	}
}
