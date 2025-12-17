package servicio;

import modelo.AppException;
import modelo.Usuario;
import repositorio.RepositorioUsuario;

public class ServicioUsuario {

	private RepositorioUsuario repo;

	public RepositorioUsuario getRepo() {
		return repo;
	}

	public void setRepo(RepositorioUsuario repo) {
		this.repo = repo;
	}

	public ServicioUsuario() {
		super();
		try {
			this.repo = new RepositorioUsuario();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ServicioUsuario [repo=" + repo + "]";
	}
	
	public void obtenerUsuarios() {
		try {
			repo.obtenerUsuarios();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscarId(String id) {
		try {
			repo.buscarPorId(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoUsuario(Usuario usuario) {
		try {
			repo.nuevoUsuario(usuario);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarPorDisposiivo(String nombreDispos) {
		repo.eliminarPorDispositivo(nombreDispos);
	}
}
