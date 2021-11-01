package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Persona;

/**
 * Servicio EJB para la entity Persona
 * @author juan
 *
 */
@Stateless
public class PersonaService extends AbstractService<Persona, Long>{
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;
		
	
	public PersonaService() {
		super(Persona.class);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Persona> getPersonas() {
		return em.createQuery("select p from Persona p order by p.nroDocumento").getResultList();
	}
		
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
