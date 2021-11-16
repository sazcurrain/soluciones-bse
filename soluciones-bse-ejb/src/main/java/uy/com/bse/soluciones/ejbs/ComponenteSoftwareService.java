package uy.com.bse.soluciones.ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.bse.soluciones.domain.Aplicacion;
import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.domain.StakeholdersComponente;

@Stateless
public class ComponenteSoftwareService extends AbstractService<ComponenteSoftware, Long> {
	
	@PersistenceContext(unitName = "soluciones_bse")
	protected EntityManager em;

	public ComponenteSoftwareService() {
		super(ComponenteSoftware.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<ComponenteSoftware> getComponentes(Class<? extends ComponenteSoftware> tipo) {
		String sql = "select TREAT(cs as "+tipo.getName()+") from ComponenteSoftware cs order by cs.nombre";
		return em.createQuery(sql).getResultList();
	}

	@Override
	public ComponenteSoftware update(ComponenteSoftware cs) {
		ComponenteSoftware nueva = super.update(cs);
		for (StakeholdersComponente a : cs.getStakeholders()) {
			a.getId().setComponenteId(nueva.getId());
			em.merge(a);
		}
		return (nueva);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<String> getTipos() {
		List<String> tipos = new ArrayList<String>();
		tipos.add("Interfaz");
		tipos.add("Aplicacion");
		tipos.add("Solucion");
		return tipos;
	}

}
