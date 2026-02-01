package hibernate_repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;

import hibernate_model.Reunion;
import jakarta.persistence.TypedQuery;
import utiles.AbstractDao;
import utiles.HibernateUtil;

public class ReunionDao extends AbstractDao<Reunion>{

	public ReunionDao() {
		setClase(Reunion.class);
	}
	
	public List<Reunion> getReunionesPasadas(LocalDateTime fechaReferencia) {
        // Abrimos la sesión usando tu utilidad habitual
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        
        try {
            String queryString = "FROM " + getClase().getName() + " WHERE fecha < :fechaParametro";
            
            TypedQuery<Reunion> query = sesion.createQuery(queryString, getClase());
            query.setParameter("fechaParametro", fechaReferencia);
            
            List<Reunion> reuniones = query.getResultList();
            return reuniones;
        } finally {
            // Es vital cerrar la sesión en el bloque finally para evitar fugas de memoria
            sesion.close();
        }
    }
	
	// Otras operaciones nuevas
}
