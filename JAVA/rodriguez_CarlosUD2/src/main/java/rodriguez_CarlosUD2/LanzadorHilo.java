package rodriguez_CarlosUD2;

public class LanzadorHilo {

	public static void main(String[] args) {

		for(int i = 0; i <= 9; i++) {
			ClienteApartado3 cliente = new ClienteApartado3();
			cliente.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
