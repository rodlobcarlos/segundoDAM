package evaluable_service;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Updates.pull;
import static com.mongodb.client.model.Updates.set;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.model.Updates;

import evaluable.Evento;
import evaluable.Usuario;
import evaluable_repository.Usuario_repository;

public class Usuario_service {

	private static final Logger logger = LogManager.getLogger(Usuario_service.class);
	private Usuario_repository repo;

	public Usuario_service(Usuario_repository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "Usuario_service [repo=" + repo + "]";
	}

	public Usuario_repository getRepo() {
		return repo;
	}

	public void setRepo(Usuario_repository repo) {
		this.repo = repo;
	}

	public static Logger getLogger() {
		return logger;
	}

	public void save(Usuario u) {
		repo.save(u);
	}

	public List<Usuario> read() {
		return repo.read();
	}

	public Usuario getPorId(String id) {
		return repo.getUsuariosFiltradosPorId(id);
	}

	public List<Usuario> ordenadoPorPlan() {
		return repo.ordenadoPorPlan();
	}

	public List<Usuario> ordenadoPorEmail() {
		return repo.ordenadoPorEmail();
	}

	public void actualizarIdioma() {
		repo.getColeccion().updateMany(eq("preferencias.idioma", "ES"), set("preferencias.idioma", "ESP"));
	}

	public void eliminarPorPlan() {
		Usuario u = new Usuario();
		Document eliminado = new Document("plan_activo", "ANUAL");
		repo.getColeccion().deleteMany(eliminado);
	}

	public void actualizarLimiteDatos() {
		repo.getColeccion().updateMany(eq("usuario.plan_activo", "VIP"), set("preferencias.limite_datos_moviles", true));
	}

	public void añadiEvento(String id) {
		Document nuevaEvento = new Document("id_evento", "ev_121").append("tag", "GPS")
				.append("mensaje", "Señal GPS adquirida").append("timestamp", "2024-02-12T08:21:00Z");
		repo.getColeccion().updateOne(eq("id", id), Updates.push("eventosLogs", nuevaEvento));
	}
}
