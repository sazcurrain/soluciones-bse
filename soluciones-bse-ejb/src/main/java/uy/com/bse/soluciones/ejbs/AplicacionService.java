package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Aplicacion;

/**
 * Servicio EJB para la entity Persona
 * 
 * @author juan
 *
 */
@Stateless
public class AplicacionService extends AbstractService<Aplicacion, Long> {

	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;

	public AplicacionService() {
		super(Aplicacion.class);
	}

	@SuppressWarnings("unchecked")
	public List<Aplicacion> getAplicaciones() {
		return em.createQuery("select a from Aplicacion a order by a.nombre").getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
