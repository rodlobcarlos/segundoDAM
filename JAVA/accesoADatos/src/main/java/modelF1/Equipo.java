package modelF1;

import java.util.List;
import java.util.Objects;

public class Equipo {

	private static int contador;
	private String nombre;
	private int puntuacion;
	private int identificadorEquipo;
	private List<Piloto> listaPilotos;
	
	public Equipo() {
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

	@Override
	public int hashCode() {
		return Objects.hash(identificadorEquipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return identificadorEquipo == other.identificadorEquipo;
	}
	
	
}
