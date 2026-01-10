package simulacroFormula1_model;

public class Pilot {

	private String name;
	private String country;
	private int points;
	private String id;
	private String teamId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "Pilot [name=" + name + ", country=" + country + ", points=" + points + ", id=" + id + ", teamId="
				+ teamId + "]";
	}

	public Pilot(String name, String country, int points, String id, String teamId) {
		super();
		this.name = name;
		this.country = country;
		this.points = points;
		this.id = id;
		this.teamId = teamId;
	}

	public Pilot() {
		super();
	}

}
