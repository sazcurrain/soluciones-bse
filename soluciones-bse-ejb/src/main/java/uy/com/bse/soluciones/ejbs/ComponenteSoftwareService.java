package uy.com.bse.soluciones.ejbs;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.domain.StakeholdersComponente;

@Stateless
public class ComponenteSoftwareService extends AbstractService<ComponenteSoftware, Long> {
	
	private StakeholdersComponente stakeholderC = new StakeholdersComponente();
	
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
	
	/**
	 * A common method for all enums since they can't have another base class
	 * @param <T> Enum type
	 * @param c enum type. All enums must be all caps.
	 * @param string case insensitive
	 * @return corresponding enum, or null
	 */
	private <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
	    if( c != null && string != null ) {
	        try {
	            return Enum.valueOf(c, string.trim().toUpperCase());
	        } catch(IllegalArgumentException ex) {
	        }
	    }
	    return null;
	}
	
	@SuppressWarnings("unchecked")
	private <T extends ComponenteSoftware>  Predicate predicateFromFilter(CriteriaBuilder cb, Root<T> root,
			Map<String, String> filter) {
		if (!filter.containsKey("field") || !filter.containsKey("value") || !filter.containsKey("op"))
			return null;

		Predicate p = null;
		switch (filter.get("op")) {
		case "=":
			Class<?> colClass = root.get(filter.get("field")).getJavaType();
			Object value = filter.get("value");
			if(colClass.isEnum()) {
				value = getEnumFromString((Class<? extends Enum>)colClass, filter.get("value"));
			} else if(colClass.equals(Date.class)) {
				try {
					SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"));
					Date d = new Date();
					System.out.println(parser.format(d));
					value = parser.parse(filter.get("value"));
					System.out.println(value.getClass());
				} catch (ParseException e) {
					System.out.println(e.getMessage());
				}  
			}
			p = cb.equal(root.get(filter.get("field")), value);
			break;
		case ">":
			p = cb.lessThan(root.get(filter.get("field")), filter.get("value"));
			break;
		case "<":
			p = cb.greaterThan(root.get(filter.get("field")), filter.get("value"));
			break;
		case "contains":
			p = cb.like(root.get(filter.get("field")), "%" + filter.get("value") + "%");
			break;
		case "starts":
			p = cb.like(root.get(filter.get("field")), filter.get("value") + "%");
			break;

		default:
			break;
		}
		return p;
	}

	private <T extends ComponenteSoftware>  Order predicateFromOrder(CriteriaBuilder cb, Root<T> root, Map<String, String> order) {
		if (!order.containsKey("field") || !order.containsKey("order"))
			return null;

		Order p = null;
		switch (order.get("order")) {
		case "ASC":
			p = cb.asc(root.get(order.get("field")));
			break;
		case "DESC":
			p = cb.desc(root.get(order.get("field")));
			break;
		default:
			break;
		}
		return p;
	}
	
	public <T extends ComponenteSoftware> int countFilteredComponentes(Class<T> tipo, List<Map<String, String>> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<T> root = q.from(tipo);
		q.select(cb.count(root));
		Predicate pFilters = null;
		for (Map<String, String> filter : filters) {
			if (pFilters != null) {
				Predicate pFilter = predicateFromFilter(cb, root, filter);
				if (pFilter != null)
					pFilters = cb.and(pFilters, pFilter);
			} else {
				pFilters = predicateFromFilter(cb, root, filter);
			}
		}
		if (pFilters != null)
			q.where(pFilters);
		

		return em.createQuery(q).getSingleResult().intValue();
	}

	public <T extends ComponenteSoftware>  List<T> filterComponentes(Class<T> tipo, int offset, int count,
			List<Map<String, String>> orders, List<Map<String, String>> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(tipo);
		Root<T> root = q.from(tipo);
		Predicate pFilters = null;
		for (Map<String, String> filter : filters) {
			if (pFilters != null) {
				Predicate pFilter = predicateFromFilter(cb, root, filter);
				if (pFilter != null)
					pFilters = cb.and(pFilters, pFilter);
			} else {
				pFilters = predicateFromFilter(cb, root, filter);
			}
		}
		if (pFilters != null)
			q.where(pFilters);

		List<Order> pOrders = new ArrayList<Order>();
		for (Map<String, String> order : orders) {
			Order pOrder = predicateFromOrder(cb, root, order);
			if (pOrder != null)
				pOrders.add(pOrder);
		}
		
		q.orderBy(pOrders);
		

		return em.createQuery(q)
				.setFirstResult(offset)
				.setMaxResults(count)
				.getResultList();
	}

	public StakeholdersComponente findStakeholderCompByid(Long id) {
		return getEntityManager().find(StakeholdersComponente.class, id);
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
