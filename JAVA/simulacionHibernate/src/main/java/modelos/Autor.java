package modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String dni;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "autores", cascade = CascadeType.ALL)
	private List<Articulo> articulos;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	@Override
	public String toString() {
		return "Autor [dni=" + dni + ", nombre=" + nombre + ", email=" + email + ", articulos=" + articulos + "]";
	}

	public Autor(String dni, String nombre, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	public Autor() {
		super();
	}
	
	public void addArticulo(Articulo articulo) {
		if(!articulos.contains(articulo)) {
			articulos.add(articulo);
		}
	}

}
