package boletin1;

import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime kernel =  Runtime.getRuntime();

		String [] argumentos2 = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};

		try {
			kernel.exec(argumentos2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
