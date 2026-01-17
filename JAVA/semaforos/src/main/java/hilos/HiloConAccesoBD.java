package hilos;

public class HiloConAccesoBD extends Thread {

	private final ConexionBBDD semaforo;

	public HiloConAccesoBD(ConexionBBDD semaforo, String nombre) {
		super();
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		semaforo.conexion();

	}
}