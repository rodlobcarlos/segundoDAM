package hibernate_repositorio;

import hibernate_model.Sala;
import utiles.AbstractDao;

public class SalaDao extends AbstractDao<Sala>{

	public SalaDao() {
		setClase(Sala.class);
	}

	
}
