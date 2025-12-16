package jdbcProyecto.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbcProyecto.models.Jugador;
import jdbcProyecto.utiles.MySqlConector;
import jdbcProyecto.utiles.TestConnection;

public class RepositorioJugadores {

	private List<Jugador> listaJugadores;
	private MySqlConector mySqlConector;
	private TestConnection connection;
	private static final Logger logger = LogManager.getLogger(RepositorioJugadores.class);

	public RepositorioJugadores(List<Jugador> listaJugadores, MySqlConector mySqlConector, TestConnection connection) {
		super();
		this.listaJugadores = listaJugadores;
		this.mySqlConector = mySqlConector;
		this.connection = connection;
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

		try {

			// Construir la sentencia INSERT según los atributos de tu clase Jugador
			// Ajusta los nombres de columnas y atributos según tu tabla
			String sql = "INSERT INTO jugadores (id, nombre, email, puntos_totales) VALUES ('" + jugador.getId() + "', "
					+ jugador.getNombre() + ", '" + jugador.getEmail() + ", '" + jugador.getPuntos_totales() + "')";

			Connection conn = mySqlConector.getConnect();
			java.sql.Statement st = conn.prepareStatement(sql);

			st.executeUpdate(sql);
			logger.info("Jugador insertado correctamente: " + jugador.getId());

		} catch (SQLException e) {
			logger.error("Error al insertar jugador: " + e.getMessage());
		}
	}
	
	public Jugador jugadorMayorPuntuacion() {
		int mayor = 0;
		for(Jugador jugador: listaJugadores) {
			
		}
		return null;
		
	}

}
