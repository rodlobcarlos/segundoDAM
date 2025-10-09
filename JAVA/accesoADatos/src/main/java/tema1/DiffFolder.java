package tema1;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiffFolder {

	private File folder1;
	private File folder2;
	private Set<ResultadoComparacion> resultados;
	
	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);

	public File getFolder1() {
		return folder1;
	}

	public void setFolder1(File folder1) {
		this.folder1 = folder1;
	}

	public File getFolder2() {
		return folder2;
	}

	public void setFolder2(File folder2) {
		this.folder2 = folder2;
	}

	public Set<ResultadoComparacion> getResultados() {
		return resultados;
	}

	public void setResultados(Set<ResultadoComparacion> resultados) {
		this.resultados = resultados;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return "DiffFolder [folder1=" + folder1 + ", folder2=" + folder2 + ", resultados=" + resultados + "]";
	}

	public DiffFolder(File folder1, File folder2, Set<ResultadoComparacion> resultados) {
		super();
		this.folder1 = folder1;
		this.folder2 = folder2;
		this.resultados = new HashSet<ResultadoComparacion>();
	}

	public void setFolders(File folder1, File folder2) throws GestionficherosException {
		if ((folder1.exists() && folder2.exists()) 
				&& (folder1.isDirectory() && folder2.isDirectory())) {
			boolean esValido1 = folder1.isDirectory();
			boolean esValido2 = folder2.isDirectory();
			logger.info("Folder1 es valido: " + esValido1);
			logger.info("Folder1 es valido: " + esValido2);
		} else if (!folder1.isDirectory() 
				|| !folder2.isDirectory()) {
			throw new GestionficherosException("No son directorios.");
		}
	}

	// Terminar
	public Set<ResultadoComparacion> compare() {
		int contador = 0;
		boolean encontrado = false;
		Iterator<ResultadoComparacion> r = resultados.iterator();
		while(!encontrado && r.hasNext()) {
			ResultadoComparacion resultado = r.next();
			contador++;
			resultados.add(resultado);
		}
		return resultados;
	}
}