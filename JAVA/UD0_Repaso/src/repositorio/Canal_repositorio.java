package repositorio;

import java.util.List;

import modelo.Canal;

public class Canal_repositorio {

	private List<Canal> canal;

	public List<Canal> getCanal() {
		return canal;
	}

	public void setCanal(List<Canal> canal) {
		this.canal = canal;
	}

	public Canal_repositorio(List<Canal> canal) {
		super();
		this.canal = canal;
	}
	
	
}
