package hibernate_repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;

import hibernate_model.Sala;
import jakarta.persistence.TypedQuery;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class SalaDao extends AbstractDao<Sala> {

	public SalaDao() {
		setClase(Sala.class);
	}

	public Sala getSalaConMasReuniones() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		try {
			// Consultamos la sala agrupando por el objeto sala y contando sus ocurrencias
			// en la tabla Reunion
			String hql = "SELECT r.sala FROM Reunion r GROUP BY r.sala ORDER BY COUNT(r) DESC";

			TypedQuery<Sala> query = sesion.createQuery(hql, Sala.class);

			// Limitamos el resultado a 1 para obtener solo la que tiene el máximo
			query.setMaxResults(1);

			return query.getSingleResult();
		} catch (Exception e) {
			// En caso de que no haya reuniones aún, devolvemos null
			return null;
		} finally {
			sesion.close();
		}
	}

}
