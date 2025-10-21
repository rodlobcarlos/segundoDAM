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

	public DiffFolder(File folder1, File folder2) {
		super();
		this.folder1 = folder1;
		this.folder2 = folder2;
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

	public Set<ResultadoComparacion> compare() throws GestionficherosException {
		Set<File> ficheros_orden = getNUmFicheroPorDirectorio(folder1, folder2);
		for(File r: ficheros_orden) {
			File[] ficheros = r.listFiles();
			for(File f: ficheros) {
				ValorComparacion valor = getValorComparacion(f);
				ResultadoComparacion objeto = new ResultadoComparacion(f.getName(), valor, f.lastModified());
				logger.info(objeto.toString());
			}
		}
		return null;
		
	}

	private ValorComparacion getValorComparacion(File file) throws GestionficherosException {
		long fecha1 = 0;
		long fecha2 = 0;
		ValorComparacion valor = null;
		boolean encontrado1 = false;
		boolean encontrado2 = false;
		boolean sonDirectorios = setFolders(folder1, folder2);
		if(sonDirectorios) {
			for(File g: folder1.listFiles()) {
				if(g.getName().equals(file.getName())) {
					encontrado1 = true;
					fecha1 = g.lastModified();
				}
			}
			for(File w: folder2.listFiles()) {
				if(w.getName().equals(file.getName())) {
					encontrado2 = true;
					fecha2 = w.lastModified();
				}
			}
			if(encontrado1 && !encontrado2) {
				valor = ValorComparacion.FALTA_EN_2;
			}else if(!encontrado1 && encontrado2) {
				valor = ValorComparacion.FALTA_EN_1;
			}else if(encontrado1 && encontrado2) {
				if(fecha1 > fecha2) {
					valor = ValorComparacion.MENOS_NUEVO_EN_1;
				}else if(fecha2 > fecha1) {
					valor = ValorComparacion.MENOS_NUEVO_EN_2;
				}else {
					valor = ValorComparacion.IGUALES;
				}
			}
		}
		return valor;
	}

	public Set<File> getNUmFicheroPorDirectorio(File fichero1, File fichero2) throws GestionficherosException {
		File[] ficheros_folder1 = folder1.listFiles();
		File[] ficheros_folder2 = folder2.listFiles();
		boolean sonDirectorios = setFolders(fichero1, fichero2);
		Set<File> orden_ficheros = new HashSet<File>();
		if (sonDirectorios) {
			if (ficheros_folder1.length >= ficheros_folder2.length) {
				orden_ficheros.add(fichero1);
				orden_ficheros.add(fichero2);
			} else {
				orden_ficheros.add(fichero2);
				orden_ficheros.add(fichero1);
			}
		}
		
		logger.debug(ficheros_folder1.length);
		logger.debug(ficheros_folder2.length);
		return orden_ficheros;

	}

}