package tema1;

import java.io.FileNotFoundException;

public class GestionaContadorPalabras {

	public static void main(String[] args) {

		ContadorPalabras c = new ContadorPalabras();
		try {
			System.out.println(c.cuentaPalabras("es", "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\resources\\Fichero.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.escribeNumero(6, "C:\\Users\\alumno\\Desktop\\segundoDAM\\JAVA\\accesoADatos\\src\\main\\resources\\Fichero.txt");
	}
}
