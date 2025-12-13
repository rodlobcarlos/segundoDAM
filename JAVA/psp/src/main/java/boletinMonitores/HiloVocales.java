package boletinMonitores;

public class HiloVocales implements Runnable{

	private String texto;
	private char vocal;
	private static int vocalesTotales;
	private int contadorVocal;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public char getVocal() {
		return vocal;
	}
	public void setVocal(char vocal) {
		this.vocal = vocal;
	}
	public static int getVocalesTotales() {
		return vocalesTotales;
	}
	public void setVocalesTotales(int vocalesTotales) {
		this.vocalesTotales = vocalesTotales;
	}
	public int getContadorVocal() {
		return contadorVocal;
	}
	public void setContadorVocal(int contadorVocal) {
		this.contadorVocal = contadorVocal;
	}
	
	public HiloVocales(String texto, char vocal) {
		super();
		this.texto = texto;
		this.vocal = vocal;
		this.vocalesTotales = 0;
		this.contadorVocal = 0;
	}
	
	@Override
	public String toString() {
		return "HiloVocales [texto=" + texto + ", vocal=" + vocal + ", vocalesTotales=" + vocalesTotales
				+ ", contadorVocal=" + contadorVocal + "]";
	}
	@Override
	public void run() {
		contarVocal();
		actualizarContadorTotal();
		
	}	
	
	synchronized void contarVocal() {
		String textoMinusculas = texto.toLowerCase();
		char vocalMinuscula = Character.toLowerCase(vocal);
		
		// Recorrer cada carácter del texto
		for (int i = 0; i < textoMinusculas.length(); i++) {
			if (textoMinusculas.charAt(i) == vocalMinuscula) {
				contadorVocal++;
			}
		}
	}
	
	synchronized void actualizarContadorTotal() {
		vocalesTotales += contadorVocal;
	}
}
