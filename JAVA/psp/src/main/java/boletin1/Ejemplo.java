package boletin1;

import java.io.IOException;

public class Ejemplo {

	public static void main(String[] args) {

		/*
		Runtime kernel =  Runtime.getRuntime();
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.freeMemory());
		System.out.println(kernel.totalMemory());
		*/
		/*
		String [] argumentos1 = {"notepad", "file.txt"};
		try {
			kernel.exec(argumentos1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		/*
		String [] argumentos2 = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};

		try {
			kernel.exec(argumentos2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		Runtime rt = Runtime.getRuntime();
		String[] informacionProceso = {"NotePad.exe"};
		Process proceso;
		try {
			proceso = rt.exec(informacionProceso);
			int codigoRetorno = proceso.waitFor(); //Espero a que termine
			System.out.println("Despues del wait: " + codigoRetorno);
		} catch (IOException e) {
			e.getMessage();
		} catch (InterruptedException e) {
			e.getMessage();
		}
		*/
		
		/*
		String[] comando = {"C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe"};
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			Process p = pb.start();
			pb.start(); // Se abre otra vez el chrome;
		} catch(IOException e) {
			e.getMessage();
		}
		*/
		
		// 3
		/*
		String[] comando = {"cmd.exe", "/c", "start", "cmd.exe", "/k", "tasklist "};
        ProcessBuilder pb = new ProcessBuilder(comando);
	        try {
	            Process process = pb.start();
	            System.out.println("Proceso finalizado");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	      */
		
		
	        
	}

}
