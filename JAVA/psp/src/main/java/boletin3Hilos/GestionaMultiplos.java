package boletin3Hilos;

public class GestionaMultiplos {

	public static void main(String[] args) {
		long t_comienzo = System.currentTimeMillis();
//		Multiplos multDe2 = new Multiplos(2);
//		Multiplos multDe3 = new Multiplos(3);
//		Multiplos multDe7 = new Multiplos(7);
		MultiplosCooperativos objetoMultiplo = new MultiplosCooperativos();

		MultiploCooperativos2 hilo2 = new MultiploCooperativos2(objetoMultiplo);
		MultiploCooperativos3 hilo3 = new MultiploCooperativos3(objetoMultiplo);
		MultiploCooperativos7 hilo7 = new MultiploCooperativos7(objetoMultiplo);

//		Thread hilo1 = new Thread(multDe2);
//		Thread hilo2 = new Thread(multDe3);
//		Thread hilo3 = new Thread(multDe7);
		try {
			hilo2.start();
			hilo3.start();
			hilo7.start();
			hilo2.join();
			hilo3.join();
			hilo7.join();

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		long t_fin = System.currentTimeMillis();
		long tiempototal = t_fin - t_comienzo;
		System.out.println("El proceso total ha tardado= " + tiempototal + "mseg");

	}

// --- Clases --- 

	class Multiplos implements Runnable {

		private int numero;

		public Multiplos(int numero) {
			super();
			this.numero = numero;
		}

		@Override
		public void run() {
			multiplicar(numero);

		}

		public void multiplicar(int numero) {
			for (int i = 1; i <= 10; i++) {
				int multiplicacion = i * numero;
				System.out.println(multiplicacion);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		class MultiplosCooperativos extends Thread {
			public void multiplicar(int numero) {
				for (int i = 1; i <= 10; i++) {
					int multiplicacion = i * numero;
					System.out.println(multiplicacion);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		class MultiploCooperativos2 extends Thread {

			private int numero;
			private MultiplosCooperativos multiplo;

			@Override
			public void run() {
				multiplo.multiplicar(2);
			}
		}

		class MultiploCooperativos3 extends Thread {

			private int numero;
			private MultiplosCooperativos multiplo;

			@Override
			public void run() {
				multiplo.multiplicar(3);
			}
		}

		class MultiploCooperativos7 extends Thread {

			private int numero;
			private MultiplosCooperativos multiplo;

			@Override
			public void run() {
				multiplo.multiplicar(7);
			}
		}
	}
}
