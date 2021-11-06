package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Cluster;

/**
 * Servicio EJB para la entity Cluster
 * @author aem
 *
 */
@Stateless
public class ClusterService extends AbstractService<Cluster, Long>{
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;
		
	
	public ClusterService() {
		super(Cluster.class);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Cluster> getClusters() {
		return em.createQuery("select p from Cluster p order by p.nombre").getResultList();
	}
		
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
