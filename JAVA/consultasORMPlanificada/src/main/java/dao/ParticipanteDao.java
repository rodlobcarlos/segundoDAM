package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelos.Participante;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ParticipanteDao extends AbstractDao<Participante> {

	public ParticipanteDao() {
		setClase(Participante.class);
	}
	
	public List<Object[]> participantesOrdenadosPorApellidos() {
	    Session session = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        String hql = "SELECT p.apellidos, p.nombre, p.email FROM Participante p " +
	                     "WHERE p.apellidos = p.apellidos "
	                     + "ORDER BY p.apellidos asc";

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