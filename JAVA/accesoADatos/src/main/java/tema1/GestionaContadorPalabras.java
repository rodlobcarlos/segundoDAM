//package tema1;
//
//import java.io.File;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;
//
//
//
//public class GestionaContadorPalabras {
//	
//	private static final Logger logger = LogManager.getLogger(GestionaContadorPalabras.class);
//
//
//	public static void main(String[] args) {
//
//		ContadorPalabras c = new ContadorPalabras();
//		String ruta_fichero = "src\\main\\resources\\Fichero.txt";
//		File ruta = new File(ruta_fichero);
//		String ruta_fichero1 = "src\\main\\resources\\Es.txt";
//		File ruta1 = new File(ruta_fichero1);
//		try {
//			int num_veces = c.cuentaPalabras("es", ruta);
//			logger.info("Número de veces: " + num_veces);
//			c.escribeNumero(num_veces, ruta1);
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
