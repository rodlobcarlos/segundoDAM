package simulacionBancoAlimentos_service;

// --- Imports ---
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import simulacionBancoAlimentos_model.BancoException;
import simulacionBancoAlimentos_model.CentroLogistico;
import simulacionBancoAlimentos_model.Personal;
import simulacionBancoAlimentos_model.Trabajadores;
import simulacionBancoAlimentos_repository.BancoAlimento_repository;
import utiles.XMLDomTrabajadores;
import utiles.XMlLDomBancoAlimentos;

// --- Clase ---
public class BancoAlimento_servicio {

	// --- Atributos ---
	private BancoAlimento_repository repository;
	private XMlLDomBancoAlimentos domBancoAlimentos;
	private XMLDomTrabajadores domTrabajadores;

	// --- Getters y setters ---
	public BancoAlimento_repository getRepository() {
		return repository;
	}

	public void setRepository(BancoAlimento_repository repository) {
		this.repository = repository;
	}

	public XMlLDomBancoAlimentos getDomBancoAlimentos() {
		return domBancoAlimentos;
	}

	public void setDomBancoAlimentos(XMlLDomBancoAlimentos domBancoAlimentos) {
		this.domBancoAlimentos = domBancoAlimentos;
	}

	public XMLDomTrabajadores getDomTrabajadores() {
		return domTrabajadores;
	}

	public void setDomTrabajadores(XMLDomTrabajadores domTrabajadores) {
		this.domTrabajadores = domTrabajadores;
	}

	// --- toString ---
	@Override
	public String toString() {
		return "BancoAlimento_servicio [repository=" + repository + ", domBancoAlimentos=" + domBancoAlimentos
				+ ", domTrabajadores=" + domTrabajadores + "]";
	}

	// --- Constructor sin parámetros ---
	public BancoAlimento_servicio() {
		super();
		this.repository = new BancoAlimento_repository(); // inicializa objeto
		this.domBancoAlimentos = new XMlLDomBancoAlimentos(); // inicializa objeto
		this.domTrabajadores = new XMLDomTrabajadores(); // inicializa objeto
	}

	// --- llamada al método de añadir centro logistico
	public void añadirCentro(CentroLogistico centroLogistico) {
		try {
			repository.añadirCentro(centroLogistico);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// llamada al método de añadir trabajador al centro logistico
	public void añadirTrabajadorACentro(CentroLogistico centroLogistico, Trabajadores trabajadores) {
		try {
			repository.añadirTrabajadorACentro(centroLogistico, trabajadores);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// llamada al método de leer centro logistico por id
	public CentroLogistico leerCentro(String id) throws BancoException {
		return repository.leerCentro(id);
	}

	// llamada al método de leer trabajaor por dni
	public Trabajadores leerTrabajador(String dni) throws BancoException {
		return repository.leerTrabajador(dni);
	}

	// llamada al método de leer la lista de centros desde xml
	public List<CentroLogistico> leerCentroListDesdeXML(String rutaFichero) throws Exception {
		return domBancoAlimentos.leerCentroListDesdeXML(rutaFichero);
	}

	// --- Método para obtener trabajador por tipo ---
	// se pasa lista por parámetro que ya carga los trabajadores del xml
	public List<Trabajadores> tipoTrabajador(Personal personal, List<Trabajadores> trabajadores) {
		List<Trabajadores> list = new ArrayList<Trabajadores>(); // lista vacía de trabajadores
		for (Trabajadores t : trabajadores) {
			if (t.getTipo().equals(personal)) {
				list.add(t);
			}
		}
		return list;
	}

	//  llamada al método de leer la lista de trabajadores desde xml
	public List<Trabajadores> leerTrabajadoresListDesdeXML(String rutaFichero) throws Exception {
		return domTrabajadores.leerTrabajadoresListDesdeXML(rutaFichero);
	}

	// --- Métedo para escribir el csv de los trabajadores de tipo VOLUNTARIO
	// se pasa lista por parámetro que ya carga los centros del xml 
	public void escribeVoluntarios(List<CentroLogistico> centroLogisticos, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			// abre el fichero de texto
			ficheroSalida = new FileWriter(rutaFichero);
			// escribe el listado centro a centro
			out = new PrintWriter(ficheroSalida);
			// por cada centro logistico...
			for (CentroLogistico c : centroLogisticos) {
				// guardo el id y la ciudad que me piden de los centros
				String id = c.getId();
				String ciudad = c.getCiudad();
				// por cada trabajador de la lista de estos que tiene el centro...
				for (Trabajadores t : c.getListaTrabajadores()) {
					if (t.getTipo().equals(Personal.VOLUNTARIO)) {
						// contenido del csv
						out.printf("NombreV: %s, DniV: %s, FechaNac: %s, identificacionC: %s, CuidadC: %s%n",
								t.getNombre(), t.getDNI(), t.getFecha_nacimiento(), id, ciudad);
					}
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
