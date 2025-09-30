package modelo;

import java.util.Objects;

public class Usuario {

	private int id_usuario;
	private String nombre;
	private String email;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Usuario(int id_usuario, String nombre, String email) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id_usuario == other.id_usuario;
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	

}
