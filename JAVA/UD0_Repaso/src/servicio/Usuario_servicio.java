package servicio;

import modelo.Usuario;
import repositorio.Usuario_repositorio;

public class Usuario_servicio {

	private Usuario_repositorio repo;

	public Usuario_servicio() {
		super();
		this.repo = new Usuario_repositorio();
	}

	public Usuario_repositorio getRepo() {
		return repo;
	}

	public void setRepo(Usuario_repositorio repo) {
		this.repo = repo;
	}
	
	public void addUsuario(Usuario u) {
		this.repo.addUsuario(u);
	}
	
	public void deleteUsuario(Usuario u) {
		this.deleteUsuario(u);
	}
	
	public void readUsuario(Usuario u) {
		this.readUsuario(u);
	}
	
}
