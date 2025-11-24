package hilos;

public class CarreraEjemplo {
	public static void main(String[] args) throws InterruptedException {
		long t_inicio = System.currentTimeMillis();
		Contador contador = new Contador();
		Thread t1 = new Thread(new TareaIncremento(contador));
		Thread t2 = new Thread(new TareaIncremento(contador));
		Thread t3 = new Thread(new TareaIncremento(contador));
		Thread t4 = new Thread(new TareaIncremento(contador));
		Thread t5 = new Thread(new TareaIncremento(contador));
		Thread t6 = new Thread(new TareaIncremento(contador));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
		System.out.println("Valor final: " + contador.getValor());
		long t_fin = System.currentTimeMillis();
		long tiempoTotal = t_fin-t_inicio;
		System.out.println("El proceso total ha tardado: " + tiempoTotal + " seg");
	}
}

class Contador {
	private int valor = 0;

	public synchronized void incrementar() {
		valor++;
	}

	public int getValor() {
		return valor;
	}
}

class TareaIncremento implements Runnable {
	private Contador contador;

	public TareaIncremento(Contador contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			contador.incrementar();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
