package jdbcProyecto.models;

import java.time.LocalDate;

public class Partida {

	private int id;
	private String narrador;
	private LocalDate fecha;
	private Resultado resultado;
	
	@Override
	public String toString() {
		return "Partida [id=" + id + ", narrador=" + narrador + ", fecha=" + fecha + ", resultado=" + resultado + "]";
	}

	public Partida(int id, String narrador, LocalDate fecha, Resultado resultado) {
		super();
		this.id = id;
		this.narrador = narrador;
		this.fecha = fecha;
		this.resultado = resultado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNarrador() {
		return narrador;
	}

	public void setNarrador(String narrador) {
		this.narrador = narrador;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}	
}
