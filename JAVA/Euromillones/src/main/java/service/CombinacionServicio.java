package service;

import java.io.FileNotFoundException;

import repository.HistoricoCombinaciones;

public class CombinacionServicio {

	private HistoricoCombinaciones repo;

	public HistoricoCombinaciones getRepo() {
		return repo;
	}

	public void setRepo(HistoricoCombinaciones repo) {
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "CombinacionServicio [repo=" + repo + "]";
	}

	public CombinacionServicio(HistoricoCombinaciones repo) {
		super();
		this.repo = repo;
	}
	
	public int estrellaMasRepetida() {
		try {
			repo.leerCSV("C:\\Users\\rodlo\\Downloads\\Euromillones 2004 a 2023 (1)");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
