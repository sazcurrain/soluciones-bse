package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import uy.com.bse.soluciones.domain.ComponenteSoftware;
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

	public ConsultaAvanzadaController() {

	}
	
	/*@PostConstruct
	public void init() {
		filteredComponentes = new LazyComponenteDataModel(componenteService);
	}*/
	/**
	 * Retorno la lista de SolInfra cargadas en la BD
	 * 
	 * @return List<Servidor>
	 */
	public List<ComponenteSoftware> getListaSolInfra() {
		return componenteService.getComponentes(ComponenteSoftware.class);

	}
	
	public List<String> getTipos(){
		return componenteService.getTipos();
	}
	
	public String getViewUrl(ComponenteSoftware componente) {
		String url = "view"+componente.getClase()+".xhtml?id="+componente.getId();
		return url;
	}
	

	public LazyComponenteDataModel getFilteredComponentes() {
		return filteredComponentes;
	}

	public void setFilteredComponentes(LazyComponenteDataModel filteredComponentes) {
		this.filteredComponentes = filteredComponentes;
	}
}
