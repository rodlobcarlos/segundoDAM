package tema1;



import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestionaFolder {
	
	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);


	public static void main(String[] args) {
		
		String directorioGeneralCasa1 = "C:\\Users\\rodlo\\Documents\\GitHub\\segundoDAM\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\java";
		String directorioGeneralCasa2 = "C:\\Users\\rodlo\\Documents\\GitHub\\segundoDAM\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\java\\tema1";
		String directorioGeneralCasa3 = "C:\\Users\\rodlo\\Documents\\GitHub\\segundoDAM\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\resources";
		String directorioGeneralCasa4 = "C:\\Users\\rodlo\\Documents\\GitHub\\segundoDAM\\segundoDAM\\JAVA\\accesoADatos";
		
		File folder1 = new File(directorioGeneralCasa1);
		File folder2 = new File(directorioGeneralCasa2);
		File folder3 = new File(directorioGeneralCasa1);
		File folder4 = new File(directorioGeneralCasa2);
		DiffFolder df = new DiffFolder(folder1, folder1);
		try {
			df.compare();
		}catch(GestionficherosException e) {
			e.printStackTrace();
		}

	}

}
