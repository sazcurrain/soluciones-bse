package uy.com.bse.soluciones.ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.SolInfra;

@Stateless
public class SolInfraService extends AbstractService<SolInfra, Long> {
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;

	public SolInfraService() {
		super(SolInfra.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<SolInfra> getSolsInfra(Class<? extends SolInfra> tipo) {
		String sql = "select TREAT(si as "+tipo.getName()+") from SolInfra si order by si.nombre";
		return em.createQuery(sql).getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<String> getTipos() {
		List<String> tipos = new ArrayList<String>();
		tipos.add("Servidor");
		tipos.add("Cluster");
		tipos.add("Nube");
		tipos.add("Tienda");
		return tipos;
	}

}
