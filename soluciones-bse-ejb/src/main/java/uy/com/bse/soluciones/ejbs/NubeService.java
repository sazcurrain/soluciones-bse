package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Nube;

/**
 * Servicio EJB para la entity Nube
 * @author aem
 *
 */
@Stateless
public class NubeService extends AbstractService<Nube, Long>{
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;
		
	
	public NubeService() {
		super(Nube.class);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Nube> getNubes() {
		return em.createQuery("select p from Nube p order by p.nombre").getResultList();
	}
		
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
