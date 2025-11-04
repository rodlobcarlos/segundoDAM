package notes;

import java.io.IOException;

public class EjecutarProcesoSistema {

	public static void main(String[] args) {

		Runtime rt = Runtime.getRuntime(); // Ejecuta comandos del SSOO
		String[] informacionProceso = {"NotePad.exe"};
		Process proceso;
		try {
			proceso = rt.exec(informacionProceso); // Empieza el proceso
			
			/**
			 * El programa no se lanza hasta que el proceso termine.
			 * waitFor() devuelve 0 si no hay fallos y si hay,
			 * devuelve 1.
			 */
			int codigoRetorno = proceso.waitFor();
			System.out.println(codigoRetorno);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
