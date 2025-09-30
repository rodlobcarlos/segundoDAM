package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class Usuario_repositorio {

	private List<Usuario> usuario;

	public Usuario_repositorio() {
		super();
		this.usuario = new ArrayList();
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	public void addUsuario(Usuario u) {
		usuario.add(u);
	}
	
	public void deleteUsuario(Usuario u) {
		usuario.remove(u);
	}
	
	public void readUsuario(Usuario u) {
		usuario.toString();
	}

}
