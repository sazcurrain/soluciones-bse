package uy.com.bse.soluciones.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Enumeradores.TipoInterfaz;

/**
 * Servicio EJB para la entity Interfaz
 * @author juan
 *
 */
@Stateless
public class InterfazService extends AbstractService<Interfaz, Long>{
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;
		
	
	public InterfazService() {
		super(Interfaz.class);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Interfaz> getInterfaces() {
		return em.createQuery("select i from Interfaz i order by i.nombre").getResultList();
	}
		
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
