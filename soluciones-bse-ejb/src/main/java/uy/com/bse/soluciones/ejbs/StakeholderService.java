package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Persona;
import uy.com.bse.soluciones.domain.Stakeholder;

/**
 * Servicio EJB para la entity Persona
 * @author juan
 *
 */
@Stateless
public class StakeholderService extends AbstractService<Stakeholder, Long>{
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;
		
	
	public StakeholderService() {
		super(Stakeholder.class);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Stakeholder> getStakeholders() {
		return em.createQuery("select s from Stakeholder s order by s.nombre").getResultList();
	}
		
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
