package hibernate_controlador;

import java.time.LocalDateTime;

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

		System.out.println("=== INICIO DEL PROGRAMA ===");

		// -----------------------------------------------------------
		// 1. GESTIÓN DE SALAS (Entidad independiente)
		// -----------------------------------------------------------
		Sala sala1 = new Sala("Sala de Juntas");
		Sala sala2 = new Sala("Sala de Cristal");
		Sala sala3 = new Sala("Auditorio Principal");
		Sala sala4 = new Sala("Sala Creativa");

		SalaDao salaDao = new SalaDao();
		salaDao.create(sala1);
		salaDao.create(sala2);
		salaDao.create(sala3);
		salaDao.create(sala4);

		System.out.println("--- Salas Creadas ---");
		for (Sala s : salaDao.getAll())
			System.out.println(s);

		// -----------------------------------------------------------
		// 2. GESTIÓN DE REUNIONES (Depende de Sala)
		// -----------------------------------------------------------
		// Es vital que las 'salas' pasadas aquí ya tengan ID (hayan sido creadas
		// arriba)
		Reunion reunion1 = new Reunion(LocalDateTime.of(2026, 2, 1, 10, 0), "Planificación Sprint", sala1);
		Reunion reunion2 = new Reunion(LocalDateTime.of(2026, 2, 2, 12, 30), "Revisión de Presupuesto", sala2);
		Reunion reunion3 = new Reunion(LocalDateTime.of(2026, 2, 5, 20, 15), "Entrevistas de IT", sala3);
		Reunion reunion4 = new Reunion(LocalDateTime.of(2026, 2, 10, 16, 0), "Presentación de Producto", sala4);

		ReunionDao reunionDao = new ReunionDao();
		reunionDao.create(reunion1);
		reunionDao.create(reunion2);
		reunionDao.create(reunion3);
		reunionDao.create(reunion4);

		System.out.println("--- Reuniones Creadas ---");
		for (Reunion r : reunionDao.getAll())
			System.out.println(r);

		// -----------------------------------------------------------
		// 3. GESTIÓN DE ACTAS (Depende de Reunión)
		// -----------------------------------------------------------
		// Las reuniones ya existen en BBDD, así que podemos vincularlas.
		// NOTA: He corregido la lógica para que coincida el constructor con la realidad
		Acta acta1 = new Acta("Se definieron los objetivos del próximo mes.", reunion1);
		Acta acta2 = new Acta("Presupuesto aprobado por unanimidad de los socios.", reunion2);
		Acta acta3 = new Acta("El candidato seleccionado cumple con el perfil técnico.", reunion3);
		Acta acta4 = new Acta("Demo finalizada con éxito ante el cliente.", reunion4);

		ActaDao actaDao = new ActaDao();
		actaDao.create(acta1);
		actaDao.create(acta2);
		actaDao.create(acta3);
		actaDao.create(acta4);

		System.out.println("--- Actas Creadas ---");
		for (Acta a : actaDao.getAll())
			System.out.println(a);

		// -----------------------------------------------------------
		// 4. GESTIÓN DE DEPARTAMENTOS (Entidad Independiente)
		// -----------------------------------------------------------
		Departamento dep1 = new Departamento("Sistemas e Infraestructura");
		Departamento dep2 = new Departamento("Recursos Humanos");
		Departamento dep3 = new Departamento("Contabilidad y Finanzas");
		Departamento dep4 = new Departamento("I+D Desarrollo");

		DepartamentoDao departamentoDao = new DepartamentoDao();
		departamentoDao.create(dep1);
		departamentoDao.create(dep2);
		departamentoDao.create(dep3);
		departamentoDao.create(dep4);

		System.out.println("--- Departamentos Creados ---");
		for (Departamento d : departamentoDao.getAll())
			System.out.println(d);

		// -----------------------------------------------------------
		// 5. GESTIÓN DE EMPLEADOS (Depende de Departamento)
		// -----------------------------------------------------------
		Empleado emp1 = new Empleado("Carlos Jiménez", 2800.50);
		Empleado emp2 = new Empleado("Ana Martínez", 3200.00);
		Empleado emp3 = new Empleado("Luis Tobar", 2100.00);
		Empleado emp4 = new Empleado("Elena Soria", 2550.75);

		// Vinculamos con departamentos QUE YA EXISTEN (paso 4)
		// Nota: He cambiado 'setDepartamentos' a 'setDepartamento' (singular)
		// asumiendo que corregiste la clase Empleado.
		emp1.setDepartamento(dep1);
		emp2.setDepartamento(dep3);
		emp3.setDepartamento(dep2);
		emp4.setDepartamento(dep4);

		EmpleadoDao empleadoDao = new EmpleadoDao();
		// Primero los creamos para que tengan ID
		empleadoDao.create(emp1);
		empleadoDao.create(emp2);
		empleadoDao.create(emp3);
		empleadoDao.create(emp4);

		// -----------------------------------------------------------
		// 6. VINCULACIÓN N:M (Empleados <-> Reuniones)
		// -----------------------------------------------------------
		// Ahora que Empleados Y Reuniones existen en BBDD, los vinculamos.

		System.out.println("--- Asignando reuniones a empleados... ---");

		emp1.addReunion(reunion4);
		emp2.addReunion(reunion2);
		emp3.addReunion(reunion3);
		emp4.addReunion(reunion1);

		// Usamos UPDATE porque tanto el empleado como la reunión ya existen
		empleadoDao.update(emp1);
		empleadoDao.update(emp2);
		empleadoDao.update(emp3);
		empleadoDao.update(emp4);

		System.out.println("--- Empleados Finales ---");
		for (Empleado e : empleadoDao.getAll()) {
			System.out.println(e);
			// Opcional: imprimir las reuniones de cada empleado para verificar
			// System.out.println(" Reuniones: " + e.getReuniones().size());
		}

		System.out.println("=== FIN DEL PROGRAMA CON ÉXITO ===");
	}
}