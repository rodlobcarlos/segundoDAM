package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelos.Evento;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class EventoDao extends AbstractDao<Evento> {

	public EventoDao() {
		setClase(Evento.class);
	}

	public List<Object[]> eventosDuracionMayor91() {
	    Session session = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        String hql = "SELECT e.nombre, e.tipoEvento, e.duracion FROM Evento e " +
	                     "WHERE e.duracion > 91 ";

	        // 3. Crear la query
	        Query<Object[]> query = session.createQuery(hql, Object[].class);

	        // 4. Ejecutar y devolver
	        return query.getResultList();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        // 5. Siempre cerrar la sesión para evitar fugas de memoria
	        session.close();
	    }
	}
	
	public List<Object[]> ubicacionEvento(String ubicacion) {
	    Session session = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        String hql = "SELECT e.nombre, e.tipoEvento, e.fecha FROM Evento e "
	        		+ "JOIN e.ubicacion  "
	        		+ "WHERE e.ubicacion = :ubicacion";

	        // 3. Crear la query
	        Query<Object[]> query = session.createQuery(hql, Object[].class);

	        query.setParameter("ubicacion", ubicacion);

	        // 4. Ejecutar y devolver
	        return query.getResultList();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        // 5. Siempre cerrar la sesión para evitar fugas de memoria
	        session.close();
	    }
	}
	
	public List<Object[]> numParticipantes() {
	    Session session = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        String hql = "SELECT e COUNT(a) FROM Evento e "
	        		+ "FROM Participante p"
	        		+ "JOIN e.nombre a";

	        // 3. Crear la query
	        Query<Object[]> query = session.createQuery(hql, Object[].class);

	        // 4. Ejecutar y devolver
	        return query.getResultList();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        // 5. Siempre cerrar la sesión para evitar fugas de memoria
	        session.close();
	    }
	}
}