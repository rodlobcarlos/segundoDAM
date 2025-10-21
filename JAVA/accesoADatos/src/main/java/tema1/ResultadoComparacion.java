package tema1;

import java.time.LocalDate;
import java.util.Objects;

public class ResultadoComparacion {

	private String nombreArchivo;
	private ValorComparacion valor;
	private long fechaModificacion;
	
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
	public long getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(long fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	@Override
	public String toString() {
		return "ResultadoComparacion [nombreArchivo=" + nombreArchivo + ", valor=" + valor + ", fechaModificacion="
				+ fechaModificacion + "]";
	}
	public ResultadoComparacion(String nombreArchivo, ValorComparacion valor, long fechaModificacion) {
		super();
		this.nombreArchivo = nombreArchivo;
		this.valor = valor;
		this.fechaModificacion = fechaModificacion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fechaModificacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoComparacion other = (ResultadoComparacion) obj;
		return Objects.equals(fechaModificacion, other.fechaModificacion);
	}
}
