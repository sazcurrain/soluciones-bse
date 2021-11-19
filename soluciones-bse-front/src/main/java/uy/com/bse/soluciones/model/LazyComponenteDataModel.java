package uy.com.bse.soluciones.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.ejbs.ComponenteSoftwareService;

@ViewScoped
public class LazyComponenteDataModel extends LazyDataModel<ComponenteSoftware> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ComponenteSoftware> datasource;

	private List<Map<String, String>> globalFilters;

	@EJB
	private ComponenteSoftwareService compService;

//    public LazyComponenteDataModel(ComponenteSoftwareService compService) {
//    	this.compService = compService;
//    	this.setRowCount(0);
//    }

	public LazyComponenteDataModel() {
		globalFilters = new ArrayList<Map<String, String>>();
	}

	@Override
	public ComponenteSoftware getRowData(String rowKey) {
		for (ComponenteSoftware customer : datasource) {
			if (customer.getId() == Integer.parseInt(rowKey)) {
				return customer;
			}
		}

		return null;
	}

	@Override
	public String getRowKey(ComponenteSoftware customer) {
		return String.valueOf(customer.getId());
	}

	private Map<String, String> adaptFilter(FilterMeta filter) {
		Map<String, String> adapted = new HashMap<String, String>();
		adapted.put("field", filter.getField());
		adapted.put("value", filter.getFilterValue().toString());
		switch (filter.getMatchMode()) {
		case CONTAINS:
			adapted.put("op", "contains");
			break;
		case EXACT:
			adapted.put("op", "=");
			break;
		case EQUALS:
			adapted.put("op", "=");
			break;
		case GREATER_THAN:
			adapted.put("op", ">");
			break;
		case LESS_THAN:
			adapted.put("op", "<");
			break;
		case STARTS_WITH:
			adapted.put("op", "starts");
			break;
		default:
			adapted.put("op", "=");
			break;
		}
		return adapted;
	}

	private Map<String, String> adaptOrder(SortMeta sort) {
		Map<String, String> adapted = new HashMap<String, String>();
		adapted.put("field", sort.getField());
		switch (sort.getOrder()) {
		case ASCENDING:
			adapted.put("order", "ASC");
			break;
		case DESCENDING:
			adapted.put("order", "DESC");
			break;
		default:
			break;
		}
		return adapted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ComponenteSoftware> load(int offset, int pageSize, Map<String, SortMeta> sortBy,
			Map<String, FilterMeta> filterBy) {
		List<Map<String, String>> filters = new ArrayList<Map<String, String>>();
		List<Map<String, String>> orders = new ArrayList<Map<String, String>>();

		for (SortMeta s : sortBy.values()) {
			Map<String, String> order = adaptOrder(s);
			orders.add(order);
		}

		Class<? extends ComponenteSoftware> clase = ComponenteSoftware.class;
		if (globalFilters.isEmpty()) {
			for (FilterMeta f : filterBy.values()) {
				if (f.getField().equals("clase")) {
					try {
						clase = (Class<? extends ComponenteSoftware>) Class
								.forName(ComponenteSoftware.class.getPackageName() + "." + f.getFilterValue());
					} catch (ClassNotFoundException e) {
					}
				} else {
					Map<String, String> filter = adaptFilter(f);
					filters.add(filter);
				}
			}
		} else {
			for (Map<String, String> g : globalFilters) {
				if (g.get("field").equals("clase")) {
					try {
						clase = (Class<? extends ComponenteSoftware>) Class
								.forName(ComponenteSoftware.class.getPackageName() + "." + g.get("value"));
					} catch (ClassNotFoundException e) {
					}
				} else {
					filters.add(g);
				}
			}
		}

		this.datasource = (List<ComponenteSoftware>) compService.filterComponentes(clase, offset, pageSize, orders,
				filters);
		this.setRowCount(compService.countFilteredComponentes(clase, filters));
		
		return this.datasource;
	}

	public List<Map<String, String>> getGlobalFilters() {
		return globalFilters;
	}

	public void setGlobalFilters(List<Map<String, String>> globalFilters) {
		this.globalFilters = globalFilters;
	}

}
