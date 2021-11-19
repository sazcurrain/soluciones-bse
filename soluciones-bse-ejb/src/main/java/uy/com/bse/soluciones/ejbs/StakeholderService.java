package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.domain.StakeholdersComponente;
import uy.com.bse.soluciones.domain.Enumeradores.Rol;

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
	
	public List <ComponenteSoftware> getStakeholderComponentesByRol(String documento, Rol rol) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ComponenteSoftware> q = cb.createQuery(ComponenteSoftware.class);
		Root<StakeholdersComponente> root = q.from(StakeholdersComponente.class);
		q.select(root.get("componente"));
		Predicate pFilters = cb.equal(root.get("stakeholder").get("documento"), documento);
		pFilters = cb.and(pFilters, cb.equal(root.get("rol"), rol));
		q.where(pFilters);
		
		return em.createQuery(q).getResultList();
	}
	
	public boolean checkByDocumento(String documento) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Stakeholder> root = q.from(Stakeholder.class);
		q.select(cb.count(root));
		Predicate pFilters = cb.equal(root.get("documento"), documento);
		q.where(pFilters);
		
		return em.createQuery(q).getSingleResult() > 0;
	}
		
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
