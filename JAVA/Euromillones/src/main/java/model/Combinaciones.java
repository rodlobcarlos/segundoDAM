package model;

public class Combinaciones {

	private String fecha;
	private int combGanadora;
	private int estrellas;
	
	@Override
	public String toString() {
		return "Combinaciones [fecha=" + fecha + ", combGanadora=" + combGanadora + ", estrellas=" + estrellas + "]";
	}
	public Combinaciones(String fecha, int combGanadora, int estrellas) {
		super();
		this.fecha = fecha;
		this.combGanadora = combGanadora;
		this.estrellas = estrellas;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCombGanadora() {
		return combGanadora;
	}
	public void setCombGanadora(int combGanadora) {
		this.combGanadora = combGanadora;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	
	
}
