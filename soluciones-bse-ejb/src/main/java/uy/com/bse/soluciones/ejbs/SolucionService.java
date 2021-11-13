package uy.com.bse.soluciones.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Solucion;

/**
 * Servicio EJB para la entity Solucion
 * @author juan
 *
 */
@Stateless
public class SolucionService extends AbstractService<Solucion, Long>{
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;
		
	
	public SolucionService() {
		super(Solucion.class);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Solucion> getSoluciones() {
		return em.createQuery("select i from Solucion i order by i.nombre").getResultList();
	}
		
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
