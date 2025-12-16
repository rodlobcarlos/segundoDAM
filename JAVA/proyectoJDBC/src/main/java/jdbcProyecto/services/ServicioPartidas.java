package jdbcProyecto.services;

import exceptions.MiExcepcion;
import jdbcProyecto.models.Partida;
import jdbcProyecto.models.Resultado;
import jdbcProyecto.repositories.RepositorioPartidas;

public class ServicioPartidas {

	private RepositorioPartidas repo;

	public RepositorioPartidas getRepo() {
		return repo;
	}

	public void setRepo(RepositorioPartidas repo) {
		this.repo = repo;
	}

	public ServicioPartidas() throws MiExcepcion {
		super();
		this.repo = new RepositorioPartidas();
	}

	@Override
	public String toString() {
		return "ServicioPartidas [repo=" + repo + "]";
	}

	public void nuevaPartida(Partida partida) {
		repo.nuevaPartida(partida);
	}
	
	public void validaPartida(Partida partida) {
		try {
			repo.validaPartido(partida);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizarPuntuacionNarrador(int id, Resultado resultado) {
		repo.actualizarPuntuacionNarrador(id, resultado);
	}

	public void actualizarPuntuacionNoAcertante(int id, Resultado resultado) {
		repo.actualizarPuntuacionNoAcertante(id, resultado);
	}

	public void actualizarPuntuacionAcertante(int id, Resultado resultado) {
		repo.actualizarPuntuacionAcertante(id, resultado);
	}

	public void listarPartidasOrdenadasPorFecha() {
		try {
			repo.listarPartidasOrdenadasPorFecha();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrarPartida(int id) {
		repo.borrarPartida(id);
	}
}
