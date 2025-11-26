package boletinMonitores;

import java.util.List;

public class CuentaVocales {

	private List<String> texto;
	private int numVocales;

	public CuentaVocales(List<String> texto, int numVocales) {
		super();
		this.texto = texto;
		this.numVocales = numVocales;
	}

	@Override
	public String toString() {
		return "CuentaVocales [texto=" + texto + ", numVocales=" + numVocales + "]";
	}

	public List<String> getTexto() {
		return texto;
	}

	public void setTexto(List<String> texto) {
		this.texto = texto;
	}

	public int getNumVocales() {
		return numVocales;
	}

	public void setNumVocales(int numVocales) {
		this.numVocales = numVocales;
	}
	
	
}
