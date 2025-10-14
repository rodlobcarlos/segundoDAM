package tema1;

public class Notas {

	private double nota;

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Notas(double nota) {
		super();
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Notas [nota=" + nota + "]";
	}
	
	
}
