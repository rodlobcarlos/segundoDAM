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
	
	private static final Logger logger = LogManager.getLogger(DiffFolder.class);

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

	public boolean setFolders(File folder1, File folder2) throws GestionficherosException {
		if ((folder1.exists() && folder2.exists()) && (folder1.isDirectory() && folder2.isDirectory())) {
			boolean esValido1 = folder1.isDirectory();
			boolean esValido2 = folder2.isDirectory();
			logger.info("Folder1 es valido: " + esValido1);
			logger.info("Folder1 es valido: " + esValido2);
		} else if (!folder1.isDirectory() || !folder2.isDirectory()) {
			throw new GestionficherosException("No son directorios.");
		}
		return false;
	}

	// Terminar
	// Método mira quien tiene más ficheros de folder 1 y folder 2
	//Llamar al método que es comparaListaFicheros y recibe File1[], File 2[]
	// Devuelve un set de resultados, se lo añado a variable(addAll) comparacion
	//Llamo a comparaListaFicheros, lo del segundo pero al reves
	//log comparacion
	public void compare() {
		
	}
	
	private Set<ResultadoComparacion> comparaListaFicheros(File[] fichero1, File[] fichero2) {
		// Recorro fichero1, para cada fichero1 busco el fichero2
		//Si está llamo método comparaFicheros que recibe fichero1, fichero2
		/*
		 * si no está:
		 * Si isPrimero
		 * Añado creo objerto resultado(nombre fichero, FALTA_EN_1)
		 * otras
		 * Añado creo objerto resultado(nombre fichero, FALTA_EN_2)
		 */		
		return resultados;
		
	}
	
	public ResultadoComparacion comparaFichero(File fichero1, File fichero2) {
		/*
		 * Si la fecha de fichero1 es antes que la fichero2:
		 * 
		 * otras
		 */
		return null;
		
	}
	
}