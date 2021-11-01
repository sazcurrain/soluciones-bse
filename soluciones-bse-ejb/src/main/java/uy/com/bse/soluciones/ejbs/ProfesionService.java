package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Profesion;

/**
 * Servicio EJB para la entity Profesion
 * @author juan
 *
 */
@Stateless
public class ProfesionService  extends AbstractService<Profesion, Long> {
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;

	
	public ProfesionService() {
		super(Profesion.class);
	}
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Profesion> getProfesiones() {
		return em.createQuery("select p from Profesion p order by p.descripcion").getResultList();
	}
}
