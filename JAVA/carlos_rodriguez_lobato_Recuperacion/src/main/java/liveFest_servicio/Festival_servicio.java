package liveFest_servicio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import liveFest_modelo.Concierto;
import liveFest_modelo.Grupo;
import liveFest_modelo.GrupoMusicaException;
import liveFest_repositorio.RegistroFestival;
import liveFest_utiles.XMLDomConciertos;
import liveFest_utiles.XMLDomGrupo;

// --- Clase ---
public class Festival_servicio {
	private static final String resource = "src\\main\\resources\\";


	// --- Atributo ---
	private XMLDomConciertos domConciertos;
	private RegistroFestival registroFestival;
	private XMLDomGrupo domGrupo;

	// --- Getters y setters ---
	public XMLDomConciertos getDomConciertos() {
		return domConciertos;
	}

	public XMLDomGrupo getDomGrupo() {
		return domGrupo;
	}

	public void setDomGrupo(XMLDomGrupo domGrupo) {
		this.domGrupo = domGrupo;
	}

	public void setDomConciertos(XMLDomConciertos domConciertos) {
		this.domConciertos = domConciertos;
	}

	public RegistroFestival getRegistroFestival() {
		return registroFestival;
	}

	public void setRegistroFestival(RegistroFestival registroFestival) {
		this.registroFestival = registroFestival;
	}

	@Override
	public String toString() {
		return "Festival_servicio [domConciertos=" + domConciertos + ", registroFestival=" + registroFestival
				+ ", domGrupo=" + domGrupo + "]";
	}

	// --- Constructor sin parámetros---
	public Festival_servicio() {
		super();
		this.domConciertos = new XMLDomConciertos();
		this.registroFestival = new RegistroFestival();
		this.domGrupo = new XMLDomGrupo();
	}

	// llamada al método agregarGrupo
	public Grupo agregarGrupo(Grupo grupo) throws GrupoMusicaException {
		return registroFestival.agregarGrupo(grupo);
	}

	// llamada al método agregarConciertoAGrupo
	public void agregarConciertoAGrupo(Concierto concierto, Grupo grupo) {
		try {
			registroFestival.agregarConciertoAGrupo(concierto, grupo);
		} catch (GrupoMusicaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// llamada al método leerGrupo por nombre
	public Grupo leerGrupo(String nombre) throws GrupoMusicaException {
		return registroFestival.leerGrupo(nombre);
	}

	// llamada al método leerConciertoListaDesdeXML
	public List<Concierto> leerConciertoListaDesdeXML(String rutaFichero) throws Exception {
		return domConciertos.leerConciertoListaDesdeXML(rutaFichero);
	}

	// --- Métedo para escribir el csv de los trabajadores de tipo VOLUNTARIO
	public void escribeConcierto(List<Concierto> conciertos, String rutaFichero) throws Exception {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			// abre el fichero de texto
			ficheroSalida = new FileWriter(rutaFichero);
			out = new PrintWriter(ficheroSalida);
			List<Grupo> grupos = domGrupo.leerGrupoListaDesdeXML(resource);
			for(Grupo g: grupos) {
				String nombre = g.getNombre();
				String email = g.getEmail();
				for (Concierto c : conciertos) {
					// contenido del csv
					out.printf("Descripcion: %s, Fecha: %s, Nombre del grupo: %s, Email: %s%n", c.getDescripcion(),
							c.getFecha(), nombre, email);
				}
			}
			

		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}
}
