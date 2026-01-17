package hilos;

public class TareaIncremento implements Runnable{

	private Contador contador;

	public TareaIncremento(Contador contador) {
		super();
		this.contador = contador;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			contador.incrementar();
		}
	}
}
