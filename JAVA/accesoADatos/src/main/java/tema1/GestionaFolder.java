package tema1;

import java.io.File;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestionaFolder {
	
	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);


	public static void main(String[] args) {
		
		File f1 = new File("C:\\Users\\rodlo\\Desktop");
		File f2 = new File("C:\\Users\\rodlo\\Desktop");
		
		Set<ResultadoComparacion> resultados = new HashSet<ResultadoComparacion>();
		ResultadoComparacion r1 = new ResultadoComparacion("Archivo1", LocalDate.of(2025, 10, 5));
		ResultadoComparacion r2 = new ResultadoComparacion("Archivo2", LocalDate.of(2025, 5, 23));

		resultados.add(r1);
		resultados.add(r2);
		
		logger.info(resultados);
		DiffFolder d1 = new DiffFolder(f1, f2, resultados);
		
		try {
			logger.debug(d1.setFolders(f1, f2));
		} catch (GestionficherosException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}

}
