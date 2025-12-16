package jdbcProyecto.repositories;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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

	public RepositorioPartidas() throws MiExcepcion {
		super();
		this.listaPartidas = new ArrayList<Partida>();
		this.mySqlConector = new MySqlConector();
		this.connection = new TestConnection();
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
	
	

	public int nuevaPartida(Partida partida) { 
		int filas = 0;
	    String sql = "INSERT INTO RodriguezCarlosPartidas (id ,narrador_id, fecha, resultado) VALUES (?, ?, ?, ?)"; 

	    try {
	    	PreparedStatement stmt = mySqlConector.getConnect().prepareStatement(sql); //conectamos con la bbdd
	        	stmt.setInt(1, partida.getId()); 
	        	stmt.setInt(2, partida.getNarrador().getId()); 
		        stmt.setString(3, partida.getFecha().toString());
		        stmt.setString(4, partida.getResultado().toString());
		        filas = stmt.executeUpdate(); //devuelve las filas que han sido "modificadas"
		        listaPartidas.add(partida);
		        
				logger.info("Partida insertada correctamente: " + partida.getId());
	    }
	    catch (SQLException e) {
	    	logger.info(e.getMessage());
	    }
	    return filas;
	}
	
	public int validaPartido (Partida partida) throws MiExcepcion { 
	    String sql = "SELECT COUNT(*) FROM RodriguezCarlosPartidas"; 
	    int filas = 0;
	    			
	    try {
				PreparedStatement stmt = mySqlConector.getConnect().prepareStatement(sql);
		    	ResultSet rs = stmt.executeQuery();
		    	
		    	while (rs.next()) {
		    		int count = rs.getInt(1); //coge los datos de la primera fila
		    		
		    		if (count < 5) {
		    			filas = nuevaPartida(partida);
		    		}
		    		else {
		    			throw new MiExcepcion("No se pueden añadir más de 5 partidas");
		    		}
			} } catch (SQLException e) {
				// TODO Auto-generated catch block
    			logger.info(e.getMessage());
			}
			return filas;
	}

	public void actualizarPuntuacionNarrador(int id, Resultado resultado) {
		try {

			String query = "update RodriguezCarlosPartidas set narrador.puntos_totales=? where resultado=? ";
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

			String query = "update RodriguezCarlosPartidas set narrador.puntos_totales=? where resultado=? || resultado=?";
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

			String query = "update RodriguezCarlosPartidas set narrador.puntos_totales=? where resultado=? || resultado=?"
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

	public void listarPartidasOrdenadasPorFecha() throws MiExcepcion {
		String sql = "SELECT * FROM RodriguezCarlosPartidas ORDER BY fecha ASC";

		try {
			Connection conn = mySqlConector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String narrador = rs.getString("narrador_id");
				LocalDate fecha = rs.getDate("fecha").toLocalDate();
				String resultado = rs.getString("resultado");

				logger.info(
						"ID: " + id + " | Narrador: " + narrador + " | Fecha: " + fecha + " | Resultado: " + resultado);
			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			logger.error("Error al listar partidas: " + e.getMessage());
			throw new MiExcepcion("Error al consultar la base de datos: " + e.getMessage());
		}
	}

	public void borrarPartida(int id) {
		// La consulta SQL segura
		String sql = "DELETE FROM RodriguezCarlosPartidas WHERE id = ?";

		try {
			Connection conn = mySqlConector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);

			// 1. Asignamos el ID al interrogante (?)
			pst.setInt(1, id);

			pst.executeUpdate();

			pst.close();

			logger.info("Partida eliminada correctamente: " + id);
		} catch (SQLException e) {
			logger.error("Error al borrar el partida: " + e.getMessage());
		}
	}
}
