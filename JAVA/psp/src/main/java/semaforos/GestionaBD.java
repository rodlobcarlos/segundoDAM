package semaforos;

import java.util.ArrayList;
import java.util.List;

public class GestionaBD {

	public static void main(String[] args) {

		ConexionBBDD baseDatos = new ConexionBBDD(3);
		int numHilos = 6;
		
		List<Thread> hilos = new ArrayList<>();
		
		for(int i = 0; i < numHilos; i++)
		{
			hilos.add(new HiloConAccesoBD(baseDatos, "hilo"+(i+1)));
		}		
		
		for(Thread hilo : hilos)
		{
			hilo.start();
		}		
	}

}
