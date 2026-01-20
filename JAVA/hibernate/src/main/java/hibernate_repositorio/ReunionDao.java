package hibernate_repositorio;

import hibernate_model.Reunion;
import utiles.AbstractDao;

public class ReunionDao extends AbstractDao<Reunion>{

	public ReunionDao() {
		setClase(Reunion.class);
	}
	
	// Otras operaciones nuevas
}
