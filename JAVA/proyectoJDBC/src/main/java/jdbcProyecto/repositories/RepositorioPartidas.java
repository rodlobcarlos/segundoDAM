package jdbcProyecto.repositories;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.MiExcepcion;
import jdbcProyecto.models.Partida;
import jdbcProyecto.models.Resultado;
import jdbcProyecto.utiles.MySqlConector;
import jdbcProyecto.utiles.TestConnection;

public class RepositorioPartidas {

	private List<Partida> listaPartidas;
	private MySqlConector mySqlConector;
	private TestConnection connection;
	private static final Logger logger = LogManager.getLogger(RepositorioPartidas.class);

	@Override
	public String toString() {
		return "RepositorioPartidas [listaPartidas=" + listaPartidas + ", mySqlConector=" + mySqlConector
				+ ", connection=" + connection + "]";
	}

	public RepositorioPartidas(List<Partida> listaPartidas, MySqlConector mySqlConector, TestConnection connection) {
		super();
		this.listaPartidas = listaPartidas;
		this.mySqlConector = mySqlConector;
		this.connection = connection;
	}

	public List<Partida> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(List<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
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

	public static Logger getLogger() {
		return logger;
	}

	public void nuevaPartida(Partida partida) throws MiExcepcion {
		if (partida.getResultado() != null) {
			listaPartidas.add(partida);
		}
		if (listaPartidas.size() > 5) {
			throw new MiExcepcion("Ya hay 5 partidas, no puedes añadir más.");
		}

		String url = "jdbc:mysql://localhost:3308/jdbcMySqlAcceso?serverTimezone=UTC";
		String user = "usuario";
		String password = "carlos";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			java.sql.Statement st = conn.createStatement();

			// Construir la sentencia INSERT según los atributos de tu clase Partida
			// Ajusta los nombres de columnas y atributos según tu tabla
			String sql = "INSERT INTO partida (id, narrador, fecha, resultado) VALUES ('" + partida.getId() + "', "
					+ partida.getNarrador() + ", '" + partida.getFecha() + ", '" + partida.getResultado() + "')";

			st.executeUpdate(sql);
			logger.info("Partida insertada correctamente: " + partida.getId());

		} catch (SQLException e) {
			logger.error("Error al insertar partida: " + e.getMessage());
		}
	}

	public void actualizarPuntuacionNarrador(int id, Resultado resultado) {
		try {

			String query = "update partida set narrador.puntos_totales=? where resultado=? ";
			Connection conn = mySqlConector.getConnect();
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(id, 3);
			st.setString(id, resultado.ALGUNOS.toString());
			logger.info("Actualización realizada correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarPuntuacionNoAcertante(int id, Resultado resultado) {
		try {

			String query = "update partida set narrador.puntos_totales=? where resultado=? || resultado=?";
			Connection conn = mySqlConector.getConnect();
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(id, 2);
			st.setString(id, resultado.TODOS.toString());
			st.setString(id, resultado.NADIE.toString());
			logger.info("Actualización realizada correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarPuntuacionAcertante(int id, Resultado resultado) {
		try {

			String query = "update partida set narrador.puntos_totales=? where resultado=? || resultado=?"
					+ "and set narrador.puntos_totales=? where resultado=?";
			Connection conn = mySqlConector.getConnect();
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(id, 2);
			st.setString(id, resultado.TODOS.toString());
			st.setString(id, resultado.NADIE.toString());
			st.setInt(id, 3);
			st.setNString(id, resultado.ALGUNOS.toString());
			logger.info("Actualización realizada correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
