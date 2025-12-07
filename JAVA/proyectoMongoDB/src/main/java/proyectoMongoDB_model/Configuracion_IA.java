package proyectoMongoDB_model;

public class Configuracion_IA {

	private boolean permitir_autocompletado;
	private int nivel_creatividad;
	private String idioma_preferido;

	public boolean isPermitir_autocompletado() {
		return permitir_autocompletado;
	}

	public void setPermitir_autocompletado(boolean permitir_autocompletado) {
		this.permitir_autocompletado = permitir_autocompletado;
	}

	public int getNivel_creatividad() {
		return nivel_creatividad;
	}

	public void setNivel_creatividad(int nivel_creatividad) {
		this.nivel_creatividad = nivel_creatividad;
	}

	public String getIdioma_preferido() {
		return idioma_preferido;
	}

	public void setIdioma_preferido(String idioma_preferido) {
		this.idioma_preferido = idioma_preferido;
	}

	@Override
	public String toString() {
		return "Tarea [permitir_autocompletado=" + permitir_autocompletado + ", nivel_creatividad=" + nivel_creatividad
				+ ", idioma_preferido=" + idioma_preferido + "]";
	}

	public Configuracion_IA(boolean permitir_autocompletado, int nivel_creatividad, String idioma_preferido) {
		super();
		this.permitir_autocompletado = permitir_autocompletado;
		this.nivel_creatividad = nivel_creatividad;
		this.idioma_preferido = idioma_preferido;
	}

	public Configuracion_IA() {
		super();
	}
}
