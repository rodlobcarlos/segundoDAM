package json;

public class Pokemon {
	
	private int id;
	private String nombre;
	private String tipo;
	private float altura_m;
	private float peso_kg;
	private String habilidadPrincipal;
	private String evoluciona_a;
	
	public Pokemon(int id, String nombre, String tipo, float altura_m, float peso_kg, String habilidadPrincipal,
			String evoluciona_a) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.altura_m = altura_m;
		this.peso_kg = peso_kg;
		this.habilidadPrincipal = habilidadPrincipal;
		this.evoluciona_a = evoluciona_a;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", altura=" + altura_m + ", peso=" + peso_kg
				+ ", habilidadPrincipal=" + habilidadPrincipal + ", evoluciona_a=" + evoluciona_a + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getAltura() {
		return altura_m;
	}

	public void setAltura(float altura_m) {
		this.altura_m = altura_m;
	}

	public float getPeso() {
		return peso_kg;
	}

	public void setPeso(float peso_kg) {
		this.peso_kg = peso_kg;
	}

	public String getHabilidadPrincipal() {
		return habilidadPrincipal;
	}

	public void setHabilidadPrincipal(String habilidadPrincipal) {
		this.habilidadPrincipal = habilidadPrincipal;
	}

	public String getEvoluciona_a() {
		return evoluciona_a;
	}

	public void setEvoluciona_a(String evoluciona_a) {
		this.evoluciona_a = evoluciona_a;
	}
}
