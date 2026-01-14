package hibernate;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import hibernate_model.Reunion;
import utiles.HibernateUtil;

public class TestReunionHibernate {

	@Test
	void testCreateReunion() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		// Registramos una transacción
		sesion.beginTransaction();
		Reunion reunion = new Reunion();
		reunion.setAsunto("mi reunion de hoy");
		reunion.setFecha(LocalDateTime.now());
		sesion.persist(reunion);
		sesion.getTransaction().commit();
		sesion.close();
	}

}
