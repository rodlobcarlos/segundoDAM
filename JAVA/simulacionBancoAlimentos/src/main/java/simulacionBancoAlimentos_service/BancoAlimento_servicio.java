package simulacionBancoAlimentos_service;

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

public class BancoAlimento_servicio {

	private BancoAlimento_repository repository;
	private XMlLDomBancoAlimentos domBancoAlimentos;
	private XMLDomTrabajadores domTrabajadores;

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

	@Override
	public String toString() {
		return "BancoAlimento_servicio [repository=" + repository + ", domBancoAlimentos=" + domBancoAlimentos
				+ ", domTrabajadores=" + domTrabajadores + "]";
	}

	public BancoAlimento_servicio() {
		super();
		this.repository = new BancoAlimento_repository();
		this.domBancoAlimentos = new XMlLDomBancoAlimentos();
		this.domTrabajadores = new XMLDomTrabajadores();
	}

	public void añadirCentro(CentroLogistico centroLogistico) {
		try {
			repository.añadirCentro(centroLogistico);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void añadirTrabajadorACentro(CentroLogistico centroLogistico, Trabajadores trabajadores) {
		try {
			repository.añadirTrabajadorACentro(centroLogistico, trabajadores);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CentroLogistico leerCentro(String id) throws BancoException {
		return repository.leerCentro(id);
	}

	public Trabajadores leerTrabajador(String dni) throws BancoException {
		return repository.leerTrabajador(dni);
	}

	public List<CentroLogistico> leerCentroListDesdeXML(String rutaFichero) throws Exception {
		return domBancoAlimentos.leerCentroListDesdeXML(rutaFichero);
	}

	public List<Trabajadores> tipoTrabajador(Personal personal, List<Trabajadores> trabajadores) {
		List<Trabajadores> list = new ArrayList<Trabajadores>();
		for (Trabajadores t : trabajadores) {
			if (t.getTipo().equals(personal)) {
				list.add(t);
			}
		}
		return list;
	}

	public List<Trabajadores> leerTrabajadoresListDesdeXML(String rutaFichero) throws Exception {
		return domTrabajadores.leerTrabajadoresListDesdeXML(rutaFichero);
	}

	public void escribeVoluntarios(List<CentroLogistico> centroLogisticos, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (CentroLogistico c : centroLogisticos) {
				String id = c.getId();
				String ciudad = c.getCiudad();
				for (Trabajadores t : c.getListaTrabajadores()) {

					if (t.getTipo().equals(Personal.VOLUNTARIO)) {
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
