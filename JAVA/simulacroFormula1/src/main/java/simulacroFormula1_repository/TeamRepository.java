package simulacroFormula1_repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simulacroFormula1_model.Pilot;
import simulacroFormula1_model.Team;

public class TeamRepository {

	private static final Logger logger = LogManager.getLogger(TeamRepository.class);
	private List<Team> teamList;
	private List<Pilot> pilotList;

	public List<Pilot> getPilotList() {
		return pilotList;
	}

	public void setPilotList(List<Pilot> pilotList) {
		this.pilotList = pilotList;
	}

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return "TeamRepository [teamList=" + teamList + ", pilotList=" + pilotList + "]";
	}

	public TeamRepository() {
		super();
		this.teamList = new ArrayList<Team>();
		this.pilotList = new ArrayList<Pilot>();
	}

	public Team readTeam(String name) throws ExceptionF1 {
		Team team1 = null;
		boolean found = false;
		Iterator<Team> e = teamList.iterator();
		while (!found && e.hasNext()) {
			Team team2 = e.next();
			if (team2.getName().equals(name)) {
				team1 = team2;
				found = true;
			} else {
				throw new ExceptionF1("This team already exist.");
			}
		}
		return team1;
	}

	public void teamAdd(Team team) throws ExceptionF1 {
		if (teamList.contains(team)) {
			throw new ExceptionF1("This team already exist.");
		}
		teamList.add(team);
	}

	public List<Pilot> readTeamPilots(Team team) throws ExceptionF1 {
		List<Pilot> pilots = team.getPilotsList();
		return pilots;

	}

	public void pilotAdd(Pilot pilot, Team team) throws ExceptionF1 {
		List<Pilot> pilots = team.getPilotsList();
		if (pilots.contains(pilot)) {
			throw new ExceptionF1("This pilot already exist.");
		} else {
			pilots.add(pilot);
		}
	}

}
