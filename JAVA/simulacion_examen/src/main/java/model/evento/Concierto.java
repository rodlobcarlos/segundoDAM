package model.evento;

import java.time.LocalDate;

public class Concierto extends Evento{

	private String artistaPrincipal;
	private String[] artistasInvitados;
	private float alquilerUbicacion;
	private float costeArtistaPrincipal;
	private float costeArtistasInvirtados;
	
	public Concierto(int id, String nombre, LocalDate fecha, int num_entradasVendidas, int capacidad_maxima_asistentes,
			EstadoEven estado, String artistaPrincipal, String[] artistasInvitados, float alquilerUbicacion,
			float costeArtistaPrincipal, float costeArtistasInvirtados) { 
		super(id, nombre, fecha, num_entradasVendidas, capacidad_maxima_asistentes, estado);
		this.artistaPrincipal = artistaPrincipal;
		this.artistasInvitados = new String[10];
		this.alquilerUbicacion = alquilerUbicacion;
		this.costeArtistaPrincipal = costeArtistaPrincipal;
		this.costeArtistasInvirtados = costeArtistasInvirtados;
	}

	public Concierto(int id, String nombre, LocalDate fecha, int num_entradasVendidas, int capacidad_maxima_asistentes,
			EstadoEven estado) {
		super(id, nombre, fecha, num_entradasVendidas, capacidad_maxima_asistentes, estado);
		// TODO Auto-generated constructor stub
	}

	public String getArtistaPrincipal() {
		return artistaPrincipal;
	}

	public void setArtistaPrincipal(String artistaPrincipal) {
		this.artistaPrincipal = artistaPrincipal;
	}

	public String[] getArtistasInvitados() {
		return artistasInvitados;
	}

	public void setArtistasInvitados(String[] artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}

	public float getAlquilerUbicacion() {
		return alquilerUbicacion;
	}

	public void setAlquilerUbicacion(float alquilerUbicacion) {
		this.alquilerUbicacion = alquilerUbicacion;
	}

	public float getCosteArtistaPrincipal() {
		return costeArtistaPrincipal;
	}

	public void setCosteArtistaPrincipal(float costeArtistaPrincipal) {
		this.costeArtistaPrincipal = costeArtistaPrincipal;
	}

	public float getCosteArtistasInvirtados() {
		return costeArtistasInvirtados;
	}

	public void setCosteArtistasInvirtados(float costeArtistasInvirtados) {
		this.costeArtistasInvirtados = costeArtistasInvirtados;
	}

	@Override
	public double calcularCosteBase() {
		float costeBase = alquilerUbicacion + costeArtistaPrincipal + (500 * costeArtistasInvirtados);
		return costeBase;
	}

	
}
