package repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Combinaciones;

public class HistoricoCombinaciones {

	private static final Logger logger = LogManager.getLogger(HistoricoCombinaciones.class);

	private Set<Combinaciones> historico;

	public HistoricoCombinaciones(Set<Combinaciones> historico) {
		super();
		this.historico = new HashSet<Combinaciones>();
	}

	@Override
	public String toString() {
		return "HistoricoCombinaciones [historico=" + historico + "]";
	}

	public Set<Combinaciones> getHistorico() {
		return historico;
	}

	public void setHistorico(Set<Combinaciones> historico) {
		this.historico = historico;
	}

	public void agregarCombinacion(Combinaciones combinacion) {
		historico.add(combinacion);
	}

	public void eliminarCombinacion(Combinaciones combinacion) {
		historico.remove(combinacion);
	}

	public boolean actualizarCombinacion(Combinaciones combinacion) {
		boolean esActualizado = false;
		if (historico.contains(combinacion)) {
			esActualizado = true;
			Combinaciones lecturaCombinacion = leerCombinacion(combinacion.getFecha());
			historico.remove(lecturaCombinacion);
			historico.add(combinacion);
		}else {
			logger.info("Esta combinacion no existe");
		}
		return esActualizado;

	}

	public Combinaciones leerCombinacion(String fecha) {
		Combinaciones combinacion1 = null;
		boolean encontrado = false;
		Iterator<Combinaciones> c = historico.iterator();
		while (!encontrado && c.hasNext()) {
			Combinaciones combinacion2 = c.next();
			if (combinacion2.getFecha().equals(fecha)) {
				combinacion1 = combinacion2;
				encontrado = true;
			} else {
				logger.info("Esta combinacion no existe.");
			}
		}
		return combinacion1;
	}
	
	public void leerCSV(String rutaFichero) throws FileNotFoundException {
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaFichero);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { // Lectura palabra a palabra
				System.out.println(in.next()); // Aquí se hará la lectura por palabra
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}
