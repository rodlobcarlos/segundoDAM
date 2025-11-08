package ficheros;

public class PersonaF {

	private String Dni;
	private String Apellidos;
	private int Edad;
	
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public PersonaF(String dni, String apellidos, int edad) {
		super();
		Dni = dni;
		Apellidos = apellidos;
		Edad = edad;
	}
	@Override
	public String toString() {
		return "PersonaF [Dni=" + Dni + ", Apellidos=" + Apellidos + ", Edad=" + Edad + "]";
	}
	
	
}
