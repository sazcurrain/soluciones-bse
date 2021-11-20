package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.domain.Enumeradores.TipoInterfaz;
import uy.com.bse.soluciones.ejbs.ComponenteSoftwareService;
import uy.com.bse.soluciones.model.LazyComponenteDataModel;

/**
 * Backing Bean de las pantallas de Servidor
 * 
 * @author aem
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("avanzadaController")
@ViewScoped
public class ConsultaAvanzadaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LazyComponenteDataModel filteredComponentes;

	@EJB
	ComponenteSoftwareService componenteService;

	private Map<String, Map<String, Object>> filtros;

	@PostConstruct
	public void init() {
		this.filtros = new HashMap<String, Map<String, Object>>();
	}

	private String clase;

	public ConsultaAvanzadaController() {

	}

	public List<String> getTipos() {
		return componenteService.getTipos();
	}

	public TipoInterfaz[] getTiposInterfaz() {
		/*List<SelectItem> result = new ArrayList<SelectItem>();
		TipoInterfaz[] tipos = TipoInterfaz.values(); 
		for(int i = 0; i < tipos.length; i++ ) {
			result.add(new SelectItem(tipos[i], tipos[i].name()));
		}
		return result;*/
		return TipoInterfaz.values();
	}

	public String getViewUrl(ComponenteSoftware componente) {
		String url = "view" + componente.getClase() + ".xhtml?id=" + componente.getId();
		return url;
	}

	public LazyComponenteDataModel getFilteredComponentes() {
		return filteredComponentes;
	}

	public void setFilteredComponentes(LazyComponenteDataModel filteredComponentes) {
		this.filteredComponentes = filteredComponentes;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getFilterClase() {
		return (String)getFilter("clase");
	}

	public void setFilterClase(String filtroClase) {
		setFilter("clase", "=", filtroClase);
	}

	public void onChangeFiltroClase(ValueChangeEvent event) {
		if(event.getNewValue() == null || !event.getNewValue().equals("Interfaz")) {
			if(this.filtros.containsKey("tipo")) this.filtros.remove("tipo");
		}
	}
	
	public Object getFilter(String field) {
		if(this.filtros.containsKey(field)) {
			return this.filtros.get(field).get("value");
		}
		return null;
	}
	
	public void setFilter(String field, String operand, Object value) {
		if(value == null || value.toString().isEmpty()) {
			if(this.filtros.containsKey(field)) {
				this.filtros.remove(field);
			}
			return;
		}
		if(this.filtros.containsKey(field)) {
			this.filtros.get(field).put("value", value);
		} else {
			Map<String,Object> newFilter = new HashMap<String,Object>();
			newFilter.put("field", field);
			newFilter.put("op", operand);
			newFilter.put("value", value);
			this.filtros.put(field, newFilter);
		}
	}
	
	public Object getFilterId() {
		return getFilter("id");
	}
	
	public void setFilterId(String value) {
		setFilter("id", "=", value);
	}
	

	
	public Object getFilterVersion() {
		return getFilter("version");
	}
	
	public void setFilterVersion(String value) {
		setFilter("version", "contains", value);
	}

	
	public Object getFilterNombre() {
		return getFilter("nombre");
	}
	
	public void setFilterNombre(String value) {
		setFilter("nombre", "contains", value);
	}
	

	
	public Date getFilterFechaVersion() {
		return (Date)getFilter("fechaVersion");
	}
	
	public void setFilterFechaVersion(Date value) {
		setFilter("fechaVersion", "=", value);
	}
	

	
//	public SelectItem getFilterTipo() {
//		return (SelectItem)getFilter("tipo");
//	}
//	
//	public void setFilterTipo(SelectItem value) {
//		setFilter("tipo", "=", value);
//	}
	
	public Map<String, Map<String, Object>> getFiltros(){
		return this.filtros;
	}

	public TipoInterfaz getFilterTipo() {
		return (TipoInterfaz)getFilter("tipo");
	}

	public void setFilterTipo(TipoInterfaz value) {
		setFilter("tipo", "=", value);
	}
	
	public String search() {
		List<Map<String, String>> globalFilters = new ArrayList<Map<String,String>>();
		for(Map<String,Object> filter : this.filtros.values()) {
			Map<String,String> newFiltro = new HashMap<String, String>();
			for(Entry<String, Object> item : filter.entrySet()) {
				newFiltro.put(item.getKey(), item.getValue().toString());
			}
			globalFilters.add(newFiltro);
		}
		
		filteredComponentes.setGlobalFilters(globalFilters);
		
		return "";
	}
	
	public String clean() {
		this.filtros = new HashMap<String, Map<String,Object>>();
		List<Map<String, String>> globalFilters = new ArrayList<Map<String,String>>();
		filteredComponentes.setGlobalFilters(globalFilters);
		
		return "";
	}

}
