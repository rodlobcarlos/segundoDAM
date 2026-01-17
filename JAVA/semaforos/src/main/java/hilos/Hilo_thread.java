package hilos;

public class Hilo_thread extends Thread{

	public Hilo_thread(String nombre) {
		super(nombre);
	}	
	
	@Override
	public void run() {
		// itera 9 veces
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " +  getName()); // pinta el nombre del hilo 
			try {
				sleep(2000); // duerme hasta sacer otra vez el hilo
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fin del programa " + getName()); 
	}
}
