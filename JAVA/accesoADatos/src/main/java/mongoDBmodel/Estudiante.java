package mongoDBmodel;

import java.util.List;

public class Estudiante {

	private int id;
	private String name;
	private double notaMedia;
	private List<String> aficiones;
	private List<Score> scores;
	private List<Address> addresses;
	
	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public List<String> getAficiones() {
		return aficiones;
	}

	public void setAficiones(List<String> aficiones) {
		this.aficiones = aficiones;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", name=" + name + ", notaMedia=" + notaMedia + ", aficiones=" + aficiones
				+ ", scores=" + scores + ", addresses=" + addresses + "]";
	}

	public Estudiante(int id, String name, double notaMedia, List<String> aficiones, List<String> scores,
			List<String> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.notaMedia = notaMedia;
		this.aficiones = aficiones;
		this.scores = scores;
		this.addresses = addresses;
	}

	// TODO

	public Estudiante() {
		// TODO Auto-generated constructor stub
	}
}
