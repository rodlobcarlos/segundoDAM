package hibernate_repositorio;

import hibernate_model.Departamento;
import utiles.AbstractDao;

public class DepartamentoDao extends AbstractDao<Departamento> {

	public DepartamentoDao() {
		setClase(Departamento.class);
	}

}
