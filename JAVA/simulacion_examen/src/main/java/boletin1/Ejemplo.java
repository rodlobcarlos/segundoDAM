package boletin1;

import java.io.IOException;

public class Ejemplo {

	public static void main(String[] args) {

		Runtime kernel =  Runtime.getRuntime();
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.freeMemory());
		System.out.println(kernel.totalMemory());
		
		/*
		String [] argumentos1 = {"notepad", "file.txt"};
		try {
			kernel.exec(argumentos1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		String [] argumentos2 = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};

		try {
			kernel.exec(argumentos2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
