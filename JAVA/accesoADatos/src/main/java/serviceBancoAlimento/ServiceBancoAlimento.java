package serviceBancoAlimento;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import exceptionBancoAlimento.BancoException;
import modelBancoAlimento.CentroLogistico;
import modelBancoAlimento.TipoPersonal;
import modelBancoAlimento.Trabajadores;
import repositoryBancoAlimentacion.RepositoryCentroLogistico;
import utilesBancoAlimento.LecturaCentroLogistico;
import utilesBancoAlimento.LecturaTrabajador;

public class ServiceBancoAlimento {

	private RepositoryCentroLogistico repo;
	private LecturaCentroLogistico lecCentro;
	private LecturaTrabajador lecTrabajador;

	public LecturaTrabajador getLecTrabajador() {
		return lecTrabajador;
	}

	public void setLecTrabajador(LecturaTrabajador lecTrabajador) {
		this.lecTrabajador = lecTrabajador;
	}

	public LecturaCentroLogistico getLecCentro() {
		return lecCentro;
	}

	public void setLecCentro(LecturaCentroLogistico lecCentro) {
		this.lecCentro = lecCentro;
	}

	public ServiceBancoAlimento() {
		super();
		this.repo = repo;
		this.lecCentro = new LecturaCentroLogistico();
		this.lecTrabajador = new LecturaTrabajador();
	}

	public RepositoryCentroLogistico getRepo() {
		return repo;
	}

	public void setRepo(RepositoryCentroLogistico repo) {
		this.repo = repo;
	}

	public void agregarTrabajador(Trabajadores trabajadores) {
		try {
			repo.agregarTrabajador(trabajadores);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void agragarCentro(CentroLogistico centroLogistico) {
		try {
			repo.agregarCentroLogistico(centroLogistico);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void leerTrabajadores(List<Trabajadores> trabajadores, String dni) {
		try {
			repo.leerTrabajador(trabajadores, dni);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void leerCentro(String id) {
		try {
			repo.leerCentroLogistico(id);
		} catch (BancoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Trabajadores> leerTrabajadorXML(List<Trabajadores> t, String rutaFichero) {
		try {
			t = lecTrabajador.leerTrabajadoresDesdeXML(rutaFichero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public List<CentroLogistico> leerCentroXML(String rutaFichero){
		List<CentroLogistico> centroLogisticos = new ArrayList<CentroLogistico>();
		try {
			centroLogisticos = lecCentro.leerCentroLogisticoDesdeXML(rutaFichero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return centroLogisticos;
	}

	public List<Trabajadores> getColaboradoresPorTipo(List<CentroLogistico> centroLogisticos, TipoPersonal personal) {
		List<Trabajadores> trabajador = new ArrayList<Trabajadores>();
		for (CentroLogistico c: centroLogisticos) {
			List<Trabajadores> lista = c.getListaTrabajadores();
			for(Trabajadores t: lista) {
				if(t.getTipo().equals(personal)) {
					trabajador.add(t);
				}
			}
		}
		return trabajador;
	}

	public void escribePersonas(List<Trabajadores> trabajadores, List<CentroLogistico> centroLogisticos, String rutaFichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			for (Trabajadores t : trabajadores) {
				CentroLogistico centro = getCentroLogistico(t, centroLogisticos);
				out.printf("NombreV:, DniV:, FechaNacV:, NombreC:, IdentificadorC:, CiudadC:" + 
						"%s, %s, %s, %s, %s, %s%n",
						t.getNombre(),
						t.getDni(),
						t.getFechaNacimiento(),
						centro.getNombre(),
						centro.getIdCentrologistico(),
						centro.getCuidad()
						);
			}
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}
	
	public CentroLogistico getCentroLogistico(Trabajadores trabajadores, List<CentroLogistico> centroLogisticos) {
		CentroLogistico centro = null;
		boolean esEncontrado = false;
		int i = 0;
		while(!esEncontrado & i < centroLogisticos.size()) {
			if(centroLogisticos.get(i).getIdCentrologistico().equals(trabajadores.getIdCentroLogistico())) {
				esEncontrado = true;
				centro = centroLogisticos.get(i);
			} else {
				i++;
			}
		}
		return centro;
	}
}
