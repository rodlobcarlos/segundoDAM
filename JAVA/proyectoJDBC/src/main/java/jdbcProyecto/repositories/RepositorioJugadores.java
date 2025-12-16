package jdbcProyecto.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.MiExcepcion;
import jdbcProyecto.models.Jugador;
import jdbcProyecto.utiles.MySqlConector;
import jdbcProyecto.utiles.TestConnection;

public class RepositorioJugadores {

	private List<Jugador> listaJugadores;
	private MySqlConector mySqlConector;
	private TestConnection connection;
	private static final Logger logger = LogManager.getLogger(RepositorioJugadores.class);

	public RepositorioJugadores() throws MiExcepcion {
		super();
		this.listaJugadores = new ArrayList<Jugador>();
		this.mySqlConector = new MySqlConector();
		this.connection = new TestConnection();
	}

	@Override
	public String toString() {
		return "RepositorioJugadores [listaJugadores=" + listaJugadores + ", mySqlConector=" + mySqlConector
				+ ", connection=" + connection + "]";
	}

	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public MySqlConector getMySqlConector() {
		return mySqlConector;
	}

	public void setMySqlConector(MySqlConector mySqlConector) {
		this.mySqlConector = mySqlConector;
	}

	public TestConnection getConnection() {
		return connection;
	}

	public void setConnection(TestConnection connection) {
		this.connection = connection;
	}

	public void altaJugador(Jugador jugador) {
		listaJugadores.add(jugador);

		String sql = "INSERT INTO RodriguezCarlosJugadores (id, nombre, email, puntosTotales) VALUES (?, ?, ?, ?)";

		try {
			Connection conn = mySqlConector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);

			// 3. Rellenamos los huecos (?) en orden:
			pst.setInt(1, jugador.getId());
			pst.setString(2, jugador.getNombre());
			pst.setString(3, jugador.getEmail());
			pst.setInt(4, jugador.getPuntos_totales());

			pst.executeUpdate();
			pst.close();

			logger.info("Jugador insertado correctamente: " + jugador.getId());

		} catch (SQLException e) {
			logger.error("Error al insertar jugador: " + e.getMessage());
		}
	}

	public void obtenerJugadorMayorPuntuacion() throws MiExcepcion {
		String sql = "SELECT * FROM RodriguezCarlosJugadores ORDER BY puntosTotales DESC LIMIT 1";

		try {
			Connection conn = mySqlConector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Jugador jugador = new Jugador(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"),
						rs.getInt("puntosTotales"));
				rs.close();
				pst.close();

				logger.info("Jugador con mayor puntuación: " + jugador.getNombre());
			} else {
				throw new MiExcepcion("No hay jugadores en la base de datos");
			}

		} catch (SQLException e) {
			logger.error("Error al obtener jugador con mayor puntuación: " + e.getMessage());
			throw new MiExcepcion("Error al consultar la base de datos: " + e.getMessage());
		}
	}

	public void mostrarJugadoresOrdenadosPorPuntos() throws MiExcepcion {
		String sql = "SELECT nombre, puntuacion FROM RodriguezCarlosJugadores ORDER BY puntuacion DESC";

		try {
			Connection conn = mySqlConector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();

			int posicion = 1;
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				int puntuacion = rs.getInt("puntuacion");

				logger.info(posicion + ". " + nombre + " - " + puntuacion + " puntos");
				posicion++;
			}

			rs.close();
			pst.close();

			logger.info("Listado de jugadores mostrado correctamente");

		} catch (SQLException e) {
			logger.error("Error al mostrar jugadores: " + e.getMessage());
			throw new MiExcepcion("Error al consultar la base de datos: " + e.getMessage());
		}
	}

	public void borrarJugador(int id) {
		// La consulta SQL 
		String sql = "DELETE FROM RodriguezCarlosJugadores WHERE id = ?";

		try {
			Connection conn = mySqlConector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);

			// 1. Asignamos el ID al interrogante (?)
			pst.setInt(1, id);

			pst.executeUpdate();

			pst.close();

			logger.info("Jugador eliminado correctamente: " + id);
		} catch (SQLException e) {
			logger.error("Error al borrar el jugador: " + e.getMessage());
		}
	}
}
