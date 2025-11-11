package modelF1;

public class Piloto {

	private static int contador;
	private String nombre;
	private String pais;
	private int puntos;
	private int identificadorPiloto;
	private int identificadorEquipo;
	
	public Piloto() {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.puntos = puntos;
		this.identificadorPiloto = identificadorPiloto;
		this.identificadorEquipo = identificadorEquipo;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Piloto.contador = contador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getIdentificadorPiloto() {
		return identificadorPiloto;
	}

	public void setIdentificadorPiloto(int identificadorPiloto) {
		this.identificadorPiloto = identificadorPiloto;
	}

	public int getIdentificadorEquipo() {
		return identificadorEquipo;
	}

	public void setIdentificadorEquipo(int identificadorEquipo) {
		this.identificadorEquipo = identificadorEquipo;
	}

	@Override
	public String toString() {
		return "Piloto [nombre=" + nombre + ", pais=" + pais + ", puntos=" + puntos + ", identificadorPiloto="
				+ identificadorPiloto + ", identificadorEquipo=" + identificadorEquipo + "]";
	}
}
