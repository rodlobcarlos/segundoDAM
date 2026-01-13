package simulacionBancoAlimentos_model;

// --- Clase, extiende de Exception---
public class BancoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// --- Contructor con mensaje ---
	public BancoException(String mensaje) {
		super(mensaje);
	}

}
