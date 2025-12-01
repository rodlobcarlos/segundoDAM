package boletinMonitores;

public class HiloVocales extends Thread{

	private CuentaVocales vocales;
	
	public HiloVocales(CuentaVocales vocales) {
		super();
		this.vocales = vocales;
	}

	public CuentaVocales getVocales() {
		return vocales;
	}

	public void setVocales(CuentaVocales vocales) {
		this.vocales = vocales;
	}

	@Override
	public String toString() {
		return "HiloVocales [vocales=" + vocales + "]";
	}

	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int contar() {
		return 0;
	}
}
