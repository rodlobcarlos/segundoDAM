package liveFest_repositorio;

// --- Imports ---
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import liveFest_modelo.Concierto;
import liveFest_modelo.Grupo;
import liveFest_modelo.GrupoMusicaException;
import liveFest_utiles.XMLDomConciertos;

// --- Clase ---
public class RegistroFestival {

	// --- Atributos ---
	private List<Grupo> listaGrupos;
	private List<Concierto> listaConciertos;
	private static final Logger logger = LogManager.getLogger(RegistroFestival.class);


	// --- Getters y setters ---
	public List<Grupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<Concierto> getListaConciertos() {
		return listaConciertos;
	}

	public void setListaConciertos(List<Concierto> listaConciertos) {
		this.listaConciertos = listaConciertos;
	}

	// --- toString ---
	@Override
	public String toString() {
		return "RegistroFestival [listaGrupos=" + listaGrupos + ", listaConciertos=" + listaConciertos + "]";
	}

	// --- Constructor sin parámetros ---
	public RegistroFestival() {
		super();
		this.listaGrupos = new ArrayList<Grupo>(); // inicializa lista de grupos
		this.listaConciertos = new ArrayList<Concierto>(); // inicializa lista de conciertos
	}

	// Método de agregar grupo de música
	public Grupo agregarGrupo(Grupo grupo) throws GrupoMusicaException {
		if (listaGrupos.contains(grupo.getCodigo())) {
			throw new GrupoMusicaException("Este grupo con este id ya existe.");
		} else {
			listaGrupos.add(grupo);
			logger.info("Grupo añadido.");
		}
		return grupo;
	}

	// REVISAR !!!!!
	// Método de agregar concierto a un grupo
	public void agregarConciertoAGrupo(Concierto concierto, Grupo grupo) throws GrupoMusicaException {
		if (!listaGrupos.contains(grupo)) {
			Grupo registro = agregarGrupo(grupo);
			List<Concierto> conciertos = new ArrayList<Concierto>();
			conciertos.add(concierto);
			logger.info("Concierto y grupo asociados.");
		}
	}

	// --- Método de leer grupo por nombre---
	public Grupo leerGrupo(String nombre) throws GrupoMusicaException {
		Grupo grupo1 = null; // inicializa grupo1 en null
		boolean encontrado = false; // crea booleano en false
		Iterator<Grupo> g = listaGrupos.iterator(); // intera grupos
		// mientras que 'encontrado' = true y haya más elementos en 'c'...
		while (!encontrado && g.hasNext()) {
			// crea objeto grupo2 que contiene los 'g' leidos
			Grupo grupo2 = g.next();
			if (grupo2.getNombre().equals(nombre)) {
				grupo1 = grupo2; // (grupo1=null) ahora contiene grupo2
				encontrado = true;
			} else {
				throw new GrupoMusicaException("Este grupo ya existe.");
			}
		}
		return grupo1;
	}
}
