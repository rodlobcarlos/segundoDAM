package hibernate_repositorio;

import hibernate_model.Acta;
import utiles.AbstractDao;

public class ActaDao extends AbstractDao<Acta> {

	public ActaDao() {
		setClase(Acta.class);
	}

}
