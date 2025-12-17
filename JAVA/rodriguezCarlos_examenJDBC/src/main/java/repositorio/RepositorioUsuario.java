package repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbcProyecto.utiles.MySqlConector;
import jdbcProyecto.utiles.TestConnection;
import modelo.AppException;
import modelo.PlanActivo;
import modelo.Preferencias;
import modelo.Usuario;

public class RepositorioUsuario {

	private List<Usuario> listaUsuarios;
	private MySqlConector connector;
	private TestConnection connection;
	private static final Logger logger = LogManager.getLogger(RepositorioUsuario.class);

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public MySqlConector getConnector() {
		return connector;
	}

	public void setConnector(MySqlConector connector) {
		this.connector = connector;
	}

	public TestConnection getConnection() {
		return connection;
	}

	public void setConnection(TestConnection connection) {
		this.connection = connection;
	}

	public RepositorioUsuario() throws AppException {
		super();
		this.listaUsuarios = new ArrayList<Usuario>();
		this.connector = new MySqlConector();
		this.connection = new TestConnection();
	}

	public List<Usuario> obtenerUsuarios() throws AppException {
		String sql = "SELECT * FROM usuarios";

		try {
			Connection conn = connector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String plan_activo = rs.getString("plan_activo").toString();
				String dispositivo = rs.getString("dispositivo").toString();

				logger.info("ID: " + id + " | Username: " + username + " | Email: " + email + " | Plan_activo: "
						+ plan_activo + " | Dispositivo: " + dispositivo);
			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			logger.error("Error al listar los usuarios: " + e.getMessage());
			throw new AppException("Error al consultar la base de datos: " + e.getMessage());
		}
		return listaUsuarios;
	}

	public void buscarPorId(String id) throws AppException {
		Preferencias preferencias = new Preferencias();
		String sql = "SELECT * FROM usuarios, preferencias WHERE usuarios.id =?";

		try {
			Connection conn = connector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, "id");
			pst.setString(1, "preferencias");

			logger.info("Usuario: " + id + " | Preferencias: " + preferencias);

			pst.close();

			logger.info("Usurio mostrado correctamente.");

		} catch (SQLException e) {
			logger.error("Error al mostrar usuario: " + e.getMessage());
			throw new AppException("Error al consultar la base de datos: " + e.getMessage());
		}
	}

	public List<Usuario> getUsuarios(PlanActivo plan) {
		String sql = "SELECT * FROM usuarios WHERE plan_activo =?";

		try {
			Connection conn = connector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaUsuarios;

	}

	public void nuevoUsuario(Usuario usuario) throws AppException {
		if (listaUsuarios.contains(usuario.getId())) {
			throw new AppException("Este usuario ya existe.");
		}
		listaUsuarios.add(usuario);

		String sql = "INSERT INTO usuarios (id, username, email, plan_activo, dispositivo) " + "VALUES (?, ?, ?, ?)";
		try {
			Connection conn = connector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);

			// 3. Rellenamos los huecos (?) en orden:
			pst.setString(1, usuario.getId());
			pst.setString(2, usuario.getUsername());
			pst.setString(3, usuario.getEmail());
			pst.setString(4, usuario.getPlan_activo().toString());

			pst.executeUpdate();
			pst.close();

			logger.info(
					"Jugador insertado correctamente: " + usuario.getId() + usuario.getUsername() + usuario.getEmail()
							+ usuario.getPlan_activo() + usuario.getDispositivo() + usuario.getPreferencias());

		} catch (SQLException e) {
			logger.error("Error al insertar usuario: " + e.getMessage());
		}
	}

	public void eliminarPorDispositivo(String nombreDispos) {
		String sql = "DELETE FROM usuarios WHERE dispositivo=?";

		try {
			Connection conn = connector.getConnect();
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, nombreDispos);

			pst.executeUpdate();

			pst.close();

			logger.info("Usuario eliminado correctamente: " + nombreDispos);
		} catch (SQLException e) {
			logger.error("Error al borrar el usuario: " + e.getMessage());
		}
	}
}
