package tema1;

import java.time.LocalDate;

public class ResultadoComparacion {

	private String nombreArchivo;
	private ValorComparacion valor;
	private LocalDate fechaModificacion;
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public ValorComparacion getValor() {
		return valor;
	}
	public void setValor(ValorComparacion valor) {
		this.valor = valor;
	}
	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(LocalDate fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public ResultadoComparacion(String nombreArchivo, LocalDate fechaModificacion) {
		super();
		this.nombreArchivo = nombreArchivo;
		this.fechaModificacion = fechaModificacion;
	}
	@Override
	public String toString() {
		return "ResultadoComparacion [nombreArchivo=" + nombreArchivo + ", valor=" + valor + ", fechaModificacion="
				+ fechaModificacion + "]";
	}
}
