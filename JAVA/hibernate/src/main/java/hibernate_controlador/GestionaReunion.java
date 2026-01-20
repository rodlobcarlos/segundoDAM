package hibernate_controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hibernate_model.Acta;
import hibernate_model.Departamento;
import hibernate_model.Empleado;
import hibernate_model.Reunion;
import hibernate_model.Sala;
import hibernate_repositorio.ActaDao;
import hibernate_repositorio.DepartamentoDao;
import hibernate_repositorio.EmpleadoDao;
import hibernate_repositorio.ReunionDao;
import hibernate_repositorio.SalaDao;

public class GestionaReunion {

	public static void main(String[] args) {

		Sala sala = new Sala("Sala de reuniones");
		SalaDao salaDao = new SalaDao();
		salaDao.create(sala);

		List<Sala> salas = salaDao.getAll();
		for (Sala s : salas) {
			System.out.println(s);
		}

		Reunion reunion = new Reunion(LocalDateTime.now(), "Asunto", sala);
		ReunionDao dao = new ReunionDao();
		dao.create(reunion);

		List<Reunion> reuniones = dao.getAll();
		for (Reunion r : reuniones) {
			System.out.println(r);
		}

		Acta acta = new Acta("Acta reunion", reunion);
		ActaDao actaDao = new ActaDao();
		reunion.setActa(acta);
//		actaDao.create(acta);

		List<Acta> actas = actaDao.getAll();
		for (Acta a : actas) {
			System.out.println(a);
		}

		Departamento departamento = new Departamento("Departamento de tecnlogía");
		DepartamentoDao departamentoDao = new DepartamentoDao();
		departamentoDao.create(departamento);

		List<Departamento> departamentos = departamentoDao.getAll();
		for (Departamento d : departamentos) {
			System.out.println(d);
		}

		Empleado empleado = new Empleado("Carlos", 1200);
		empleado.setDepartamentos(departamento);
		EmpleadoDao empleadoDao = new EmpleadoDao();
		empleadoDao.create(empleado);

		List<Empleado> empleados = empleadoDao.getAll();
		for (Empleado e : empleados) {
			System.out.println(e);
		}
	}
}
