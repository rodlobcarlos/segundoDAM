package utiles;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate_model.Reunion;
import jakarta.persistence.TypedQuery;

public abstract class AbstractDao<T> implements IDao<T> {
	private Class<T> clase;

	@Override
	public void create(T t) {
		executeInsideTransaction(t);
	}

	public void refresh(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		sesion.refresh(t);
	}

	public T mergeaObjeto(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.merge(t);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}

		return t;
	}

	@Override
	public T get(int id) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		return sesion.find(clase, id);
	}

	@Override
	public List<T> getAll() {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		String queryString = "FROM " + clase.getName();
		TypedQuery<T> query = sesion.createQuery(queryString, clase);
		List<T> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public void update(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();
		executeInsideTransaction(sesion, sesion.merge(t));
	}

	@Override
	public void delete(T t) {
		Session sesion = HibernateUtil.getFactoriaSession().openSession();

		// Registramos una transacción
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.remove(t);
			tx.commit();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}

	}

	private void executeInsideTransaction(Session sesion, T objeto) {
		Transaction tx = null;
		try {
			tx = sesion.beginTransaction();

			sesion.persist(objeto);

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			// La sesión se cierra en el método que llama a este,
			// o si la abriste aquí, asegúrate de cerrarla.
			if (sesion != null && sesion.isOpen()) {
				sesion.close();
			}
		}
	}

	private void executeInsideTransaction(T objecto) {
		executeInsideTransaction(HibernateUtil.getFactoriaSession().openSession(), objecto);
	}

	/**
	 * @return the clase
	 */
	public Class<T> getClase() {
		return clase;
	}

	/**
	 * @param clase the clase to set
	 */
	public void setClase(Class<T> clase) {
		this.clase = clase;
	}
	
	
}
