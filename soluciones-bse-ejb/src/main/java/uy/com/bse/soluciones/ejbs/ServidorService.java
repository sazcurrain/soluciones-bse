package uy.com.bse.soluciones.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Servidor;

/**
 * Servicio EJB para la entity Servidor
 * @author aem
 *
 */
@Stateless
public class ServidorService extends AbstractService<Servidor, Long>{
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;
		
	
	public ServidorService() {
		super(Servidor.class);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Servidor> getServidores() {
		return em.createQuery("select p from Servidor p order by p.nombre").getResultList();
	}
		
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
