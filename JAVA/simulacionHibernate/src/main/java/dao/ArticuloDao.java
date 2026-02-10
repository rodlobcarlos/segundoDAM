package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelos.Articulo;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ArticuloDao extends AbstractDao<Articulo> {

	public ArticuloDao() {
		setClase(Articulo.class);
	}
	
	public List<Articulo> buscarArticulosPorNombreAutor(String nombreAutor) {
		Session session = HibernateUtil.getFactoriaSession().openSession();
	    // Definimos la consulta HQL
	    String hql = "SELECT a FROM Articulo a " +
	                 "JOIN a.autores aut " +
	                 "WHERE aut.nombre = :nombre "+
	                 "ORDER BY a.titulo ASC";
	    
	    // Creamos la query usando la sesión de Hibernate
	    Query<Articulo> query = session.createQuery(hql, Articulo.class);
	    
	    // Asignamos el valor al parámetro :nombre
	    query.setParameter("nombre", nombreAutor);
	    
	    // Ejecutamos y devolvemos la lista de resultados
	    return query.getResultList();
	}
	
	public List<Object[]> obtenerArticulosLargos() {
	    // 1. Obtener la sesión (asegúrate de usar tu clase de utilidad, ej: HibernateUtil)
	    Session session = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        // 2. Definir el HQL (calculamos la diferencia de páginas en el SELECT y en el WHERE)
	        String hql = "SELECT a.titulo, (a.numPaginaFin - a.numPaginaInicio) " +
	                     "FROM Articulo a " +
	                     "WHERE (a.numPaginaFin - a.numPaginaInicio) > 6";

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
	
	public List<Object[]> obtenerArticulosLargosConRevistaYFecha() {
	    // 1. Obtener la sesión (asegúrate de usar tu clase de utilidad, ej: HibernateUtil)
	    Session session = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        // 2. Definir el HQL (calculamos la diferencia de páginas en el SELECT y en el WHERE)
	        String hql = "SELECT a.titulo, a.revista.nombre, a.revista.fecha, (a.numPaginaFin - a.numPaginaInicio) " +
	                     "FROM Articulo a " +
	                     "WHERE (a.numPaginaFin - a.numPaginaInicio) > 6";

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
	
	public List<Object[]> obtenerNumeroArticulosPorRevista() {
	    // 1. Obtener la sesión
	    Session session = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        // 2. Definir el HQL
	        // Usamos r.nombreRevista (asegúrate de que el atributo se llame así en tu clase Revista)
	        String hql = "SELECT r.nombre, COUNT(a) " +
	                     "FROM Revista r " +
	                     "LEFT JOIN r.articulos a " +
	                     "GROUP BY r.nombre";

	        // 3. Crear la query
	        Query<Object[]> query = session.createQuery(hql, Object[].class);

	        // 4. Ejecutar y devolver
	        return query.getResultList();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        // 5. Cerrar la sesión
	        session.close();
	    }
	}
	
	public List<Object[]> obtenerRevistasAnterioresA(LocalDate fechaLimite) {
	    // 1. Obtener la sesión
	    Session session = HibernateUtil.getFactoriaSession().openSession();
	    
	    try {
	        // 2. Definición del HQL
	        String hql = "SELECT r.nombre, r.fecha, r.numeroRevista FROM Revista r WHERE r.fecha < :fechaLimite";

	        // 3. Crear la query e indicar que esperamos un array de objetos
	        Query<Object[]> query = session.createQuery(hql, Object[].class);
	        
	        // 4. ASIGNAR EL PARÁMETRO (Muy importante para que funcione el WHERE)
	        query.setParameter("fechaLimite", fechaLimite);

	        // 5. Ejecutar y devolver
	        return query.getResultList();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        session.close();
	    }
	}

}