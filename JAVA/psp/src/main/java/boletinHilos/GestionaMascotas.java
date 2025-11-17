package boletinHilos;

import java.util.ArrayList;
import java.util.List;

public class GestionaMascotas {

	public static void main(String[] args) {

		Mascota mascota = new Mascota("Lulú");
		
		List<Thread> cuidadores = new ArrayList<Thread>();
		for(int i = 1; i <= 10; i++) {
			Thread cuidador = new Thread(mascota, "Cuidador" +i);
			cuidadores.add(cuidador);
			if(i %2 == 0) {
				cuidador.setPriority(cuidador.MAX_PRIORITY);
			}else {
				cuidador.setPriority(cuidador.MIN_PRIORITY);
			}
			cuidador.setPriority(11-i);
			cuidador.start();

		}
		
		for(Thread thread: cuidadores) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(mascota.getNumVecesAlimentado());
	}
}
