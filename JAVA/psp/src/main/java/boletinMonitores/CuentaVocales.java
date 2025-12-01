package boletinMonitores;

public class CuentaVocales {

	private int numVocales;

	public CuentaVocales(int numVocales) {
		super();
		this.numVocales = numVocales;
	}

	@Override
	public String toString() {
		return "CuentaVocales [numVocales=" + numVocales + "]";
	}

	public int getNumVocales() {
		return numVocales;
	}

	public void setNumVocales(int numVocales) {
		this.numVocales = numVocales;
	}
	
	synchronized void incrementar(int numvocales) {
		this.numVocales = this.numVocales + numvocales;
	}
}
