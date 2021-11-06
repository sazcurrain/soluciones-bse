package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Tienda;

/**
 * Servicio EJB para la entity Tienda
 * @author aem
 *
 */
@Stateless
public class TiendaService extends AbstractService<Tienda, Long>{
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;
		
	
	public TiendaService() {
		super(Tienda.class);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Tienda> getTiendas() {
		return em.createQuery("select p from Tienda p order by p.nombre").getResultList();
	}
		
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
