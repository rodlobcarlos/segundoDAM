package proyectoMongoDB_service;

import java.util.List;

import proyectoMongoDB_model.ProyectoException;
import proyectoMongoDB_model.Usuario;
import proyectoMongoDB_repository.Usuario_repository;

public class Usuario_service {

	private Usuario_repository repo;

	public Usuario_repository getRepo() {
		return repo;
	}

	public void setRepo(Usuario_repository repo) {
		this.repo = repo;
	}

	public Usuario_service(Usuario_repository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "Usuario_service [repo=" + repo + "]";
	}
	
	public void save(Usuario u) {
		repo.save(u);
	}
	
	public List<Usuario> read() {
		return repo.read();
	}
	
	public void delete(Usuario u) {
		try {
			repo.delete(u);
		} catch (ProyectoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Usuario u) {
		try {
			repo.update(u);
		} catch (ProyectoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
