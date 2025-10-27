package towerGPT_service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import towerGPT_Exception.InteraccionException;
import towerGPT_model.InteraccionAgente;
import towerGPT_model.TipoAgente;
import towerGPT_repository.RepositorioInteracciones;

public class ServicioInteracciones {

	private static final Logger logger = LogManager.getLogger(ServicioInteracciones.class);

	private RepositorioInteracciones repo;

	public ServicioInteracciones(RepositorioInteracciones repo) {
		super();
		this.repo = repo;
	}

	public RepositorioInteracciones getRepo() {
		return repo;
	}

	public void setRepo(RepositorioInteracciones repo) {
		this.repo = repo;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return "ServicioInteracciones [repo=" + repo + "]";
	}

	public void agregarInteraccionARegistro(InteraccionAgente interaccionAgente) {
		repo.agregarInteraccionARegistro(interaccionAgente);
	}

	public void actualizaPorcentajeInteraccion(InteraccionAgente interaccionAgente, double porcentajeNuevo) {
		try {
			repo.actualizaPorcentajeInteraccion(interaccionAgente, porcentajeNuevo);
		} catch (InteraccionException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}

	public void borrarInteracciones(InteraccionAgente interaccionAgente) {
		repo.borrarInteracciones(interaccionAgente);
	}

	public InteraccionAgente leerInteracciones(int id) {
		try {
			repo.leerInteracciones(id);
		} catch (InteraccionException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return null;
	}

	public double incrementarNumeroValoraciones(InteraccionAgente interaccionAgente, double valoracionNueva)
			throws InteraccionException {
		if (interaccionAgente.getValoracion() != valoracionNueva) {
			valoracionNueva += 1;
		} else {
			throw new InteraccionException("No es posible incrementar la valoración.");
		}
		return valoracionNueva;
	}

	public InteraccionAgente obtenerInteraccionConMayorValoracion() {
		double mayor = 0;
		InteraccionAgente agente = null;
		for (InteraccionAgente i : repo.getRegistro()) {
			if (i.getValoracion() > mayor) {
				mayor = i.getValoracion();
				agente = i;
			}
		}
		return agente;
	}

	public int calcularTiempoMedioPorTipo(TipoAgente agente) {
		int sumaDelTipo = 0;
		int contador = 0;
		for (InteraccionAgente i : repo.getRegistro()) {
			if (i.getTipo().equals(agente)) {
				sumaDelTipo += i.getTimepoEjecucion();
				contador++;
			}
		}
		int mediaTiempo = sumaDelTipo / contador;
		return mediaTiempo;

	}

	public double calcularPorcentajeMedioPorTipos(TipoAgente agente) {
		double sumaDelTipo = 0;
		double contador = 0;
		for (InteraccionAgente i : repo.getRegistro()) {
			if (i.getTipo().equals(agente)) {
				sumaDelTipo += i.getPorcentajeAcierto();
				contador++;
			}
		}
		double mediaTiempo = sumaDelTipo / contador;
		return mediaTiempo;

	}

	public List<InteraccionAgente> obtenerInteraccionesAciertoMayorQueOrdenadas(int propuesta) {
		List<InteraccionAgente> resultado = new ArrayList<InteraccionAgente>();
		for (InteraccionAgente i : repo.getRegistro()) {
			if (i.getPorcentajeAcierto() > propuesta) {
				resultado.add(i);
			}
		}
		return resultado;
	}

	public Set<InteraccionAgente> agruparInteraccionesPorTipo(TipoAgente agente) {
	    Set<InteraccionAgente> tipo = new HashSet<>();
	    
	    for (InteraccionAgente i : repo.getRegistro()) {
	        if (i.getTipo().equals(agente)) {
	        	tipo.add(i);
	        }
		}
		return tipo;
	}

	public void escribeRegistro(Set<InteraccionAgente> registro, String ruta) { // Convertir el objeto a JSON
		Gson gson = new Gson();
		String json = gson.toJson(registro);
		// Escribir el JSON en un archivo
		FileWriter writer = null;
		try {
			writer = new FileWriter(ruta);
			writer.write(json);
		} catch (IOException e) {
			logger.info(e.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					logger.info(e.getMessage());
				}
			}
		}
	}
	
	public InteraccionAgente leeRegistro(String rutaFichero) {
		try {
			Gson gson = new Gson();
			FileReader fichero = new FileReader(rutaFichero);
			InteraccionAgente registro = gson.fromJson(fichero, InteraccionAgente.class);
			logger.debug("Registro leído: " + registro);
			fichero.close();
			return registro;

		} catch (Exception e) {
			logger.error("Error al leer el archivo JSON", e.getMessage());
			return null;
		}
	}

	public void escrituraCsv(String fichero) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(fichero);
			out = new PrintWriter(ficheroSalida);
			out.printf("id,tipo,peticion,respuesta,timepoEjecucion,valoracion,porcentajeAcierto\r\n"
					+ "1, IA, peticion1, repuesta recibida, 60, 5.0, 7.0");
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (out != null)
				out.close();
		}
	}

	public List<InteraccionAgente> leeCsv(String f) {
		List<InteraccionAgente> registro = new ArrayList<InteraccionAgente>();
		Scanner in = null;
		try {
			FileReader fichero = new FileReader(f);
			in = new Scanner(fichero);
			in.hasNextLine();
			while (in.hasNextLine()) {
				String linea = in.nextLine();
				String[] p = linea.split(",");
				String id = p[0];
				String tipo = p[1];
				String peticion = p[2];
				String respuesta = p[3];
				String timepoEjecucion = p[4];
				String valoracion =p[5];
				String porcentajeAcierto = p[6];
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return registro;
	}

}
