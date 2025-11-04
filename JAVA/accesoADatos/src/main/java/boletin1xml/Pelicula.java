package boletin1xml;

import java.util.List;

import org.w3c.dom.NodeList;

public class Pelicula {

	String titulo;
	int duracion;
	String genero;
	NodeList actores;
	
	public Pelicula() {
		super();
	}
	
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero + ", actores=" + actores
				+ "]";
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public NodeList getActores() {
		return actores;
	}
	public void setActores(NodeList actorNodo) {
		this.actores = actorNodo;
	}
	
}
