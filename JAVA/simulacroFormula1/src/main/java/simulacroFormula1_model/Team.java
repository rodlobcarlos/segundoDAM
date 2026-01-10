package simulacroFormula1_model;

import java.util.List;

public class Team {

	private String name;
	private int points;
	private String id;
	private List<Pilot> pilotsList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Pilot> getPilotsList() {
		return pilotsList;
	}

	public void setPilotsList(List<Pilot> pilotsList) {
		this.pilotsList = pilotsList;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", points=" + points + ", id=" + id + ", pilotsList=" + pilotsList + "]";
	}

	public Team(String name, int points, String id, List<Pilot> pilotsList) {
		super();
		this.name = name;
		this.points = points;
		this.id = id;
		this.pilotsList = null;
	}

	public Team() {
		super();
	}

}
