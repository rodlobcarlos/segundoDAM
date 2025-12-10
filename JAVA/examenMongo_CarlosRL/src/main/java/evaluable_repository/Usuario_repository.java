package evaluable_repository;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

import evaluable.Evento;
import evaluable.PlanActivo;
import evaluable.Preferencias;
import evaluable.Usuario;

public class Usuario_repository {

	private static final String NOMBRE_COLECCION = "usuario";
	private final MongoCollection<Document> coleccion;
	private static final Logger logger = LogManager.getLogger(Usuario_repository.class);
	private List<Usuario> listaUsuario;

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public static String getNombreColeccion() {
		return NOMBRE_COLECCION;
	}

	public MongoCollection<Document> getColeccion() {
		return coleccion;
	}

	public static Logger getLogger() {
		return logger;
	}

	public Usuario_repository(MongoDatabase db) {
		super();
		this.coleccion = db.getCollection(NOMBRE_COLECCION);
		this.listaUsuario = this.read();
	}

	@Override
	public String toString() {
		return "Usuario_repository [coleccion=" + coleccion + ", listaUsuario=" + listaUsuario + "]";
	}

	private Usuario fromDocumentUsuario2Java(Document doc) {
		Usuario u = new Usuario();
		u.setId(doc.getString("id"));
		u.setUsername(doc.getString("username"));
		u.setEmail(doc.getString("email"));
		u.setPlan_activo(PlanActivo.valueOf(doc.getString("plan_activo")));
		u.setDispositivo(doc.getString("dispositivo"));
		
		Document docPreferencias = (Document) doc.get("preferencias");
		Preferencias p = new Preferencias();
		p.setTema_oscuro(docPreferencias.getBoolean("tema_oscuro", false));
		p.setIdioma(docPreferencias.getString("idioma"));
		p.setNotificaciones_push(docPreferencias.getBoolean("notificaciones_push", false));
		p.setLimite_datos_moviles(docPreferencias.getBoolean("limite_datos_moviles", true));
		u.setPreferencias(p);
		
		List<Document> documents = doc.getList("eventosLogs", Document.class);
		List<Evento> e = new ArrayList<Evento>();
		for(Document document: documents) {
			Evento evento = new Evento();
			evento.setId_evento(document.getString("id_evento"));
			evento.setTag(document.getString("tag"));
			evento.setMensaje(document.getString("mensaje"));
			evento.setTimestamp(document.getString("timestamp"));
			e.add(evento);
		}
		u.setLogs_eventos(e);
		return u;
	}

	private Document fromUsuarioDocumentoJava(Usuario u) {
		Preferencias p = new Preferencias();
		Evento evento = new Evento();
		
		Document docUser = new Document("id", u.getId()).append("username", u.getUsername())
				.append("email", u.getEmail()).append("plan_activo", u.getPlan_activo()).append("dispositivo", u.getDispositivo())
				.append("preferencias", u.getPreferencias()).append("eventosLogs", u.getLogs_eventos());

		Document docPreferencias = new Document("tema_oscuro", p.isTema_oscuro())
				.append("idioma", p.getIdioma()).append("notificaciones_push", p.isNotificaciones_push())
				.append("limite_datos_moviles", p.isLimite_datos_moviles());

		List<Document> eventos = new ArrayList<Document>();
		for (Evento e : u.getLogs_eventos()) {
			Document docEvents = new Document("id_evento", evento.getId_evento())
					.append("tag", evento.getTag()).append("mensaje", evento.getMensaje())
					.append("timestamp", evento.getTimestamp());
			eventos.add(docEvents);
		}
		return docUser;
	}
	
	public void save(Usuario u) {
		coleccion.insertOne(fromUsuarioDocumentoJava(u));
	}
	
	public List<Usuario> read() {
		List<Usuario> usuario = new ArrayList<>();
		FindIterable<Document> documentos = coleccion.find();
		for (Document doc : documentos) {
			Usuario u = fromDocumentUsuario2Java(doc);
			usuario.add(u);
		}
		return usuario;
	}
	
	public Usuario getUsuariosFiltradosPorId(String id) {
		Document filtro = new Document("id", id); 
		Document resultado = this.coleccion.find(filtro).first();
		Usuario u = fromDocumentUsuario2Java(resultado);
		return u;
	}
	
	public List<Usuario> ordenadoPorPlan() {
		List<Usuario> list = new ArrayList<Usuario>();
		FindIterable<Document> resultado = coleccion.find().sort(Sorts.descending("plan_activo"));
		for (Document document : resultado) {
			Usuario usuario = fromDocumentUsuario2Java(document);
			list.add(usuario);
		}
		return list;
	}
	
	public List<Usuario> ordenadoPorEmail() {
		List<Usuario> list = new ArrayList<Usuario>();
		FindIterable<Document> resultado = coleccion.find().sort(Sorts.ascending("email"));
		for (Document document : resultado) {
			Usuario usuario = fromDocumentUsuario2Java(document);
			list.add(usuario);
		}
		return list;
	}
}
