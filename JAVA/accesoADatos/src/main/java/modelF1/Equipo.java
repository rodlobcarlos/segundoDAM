package modelF1;

import java.util.List;

public class Equipo {

	private static int contador;
	private String nombre;
	private int puntuacion;
	private int identificadorEquipo;
	private List<Piloto> listaPilotos;
	
	public Equipo(String nombre, int puntuacion, int identificadorEquipo, List<Piloto> listaPilotos) {
		super();
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.identificadorEquipo = contador;
		this.listaPilotos = listaPilotos;
		contador = contador+1;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Equipo.contador = contador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getIdentificadorEquipo() {
		return identificadorEquipo;
	}

	public void setIdentificadorEquipo(int identificadorEquipo) {
		this.identificadorEquipo = identificadorEquipo;
	}

	public List<Piloto> getListaPilotos() {
		return listaPilotos;
	}

	public void setListaPilotos(List<Piloto> listaPilotos) {
		this.listaPilotos = listaPilotos;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", puntuacion=" + puntuacion + ", identificadorEquipo="
				+ identificadorEquipo + ", listaPilotos=" + listaPilotos + "]";
	}
	
	
}
