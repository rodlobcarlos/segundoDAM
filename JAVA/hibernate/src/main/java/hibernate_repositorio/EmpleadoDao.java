package hibernate_repositorio;

import hibernate_model.Empleado;
import utiles.AbstractDao;

public class EmpleadoDao extends AbstractDao<Empleado> {

	public EmpleadoDao() {
		setClase(Empleado.class);
	}

}
