package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.ejbs.ComponenteSoftwareService;

/**
 * Backing Bean de las pantallas de Servidor
 * 
 * @author aem
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("simpleController")
@ViewScoped
public class ConsultaSimpleController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ComponenteSoftware> filteredComponentes;

	@EJB
	ComponenteSoftwareService componenteService;

	public ConsultaSimpleController() {

	}

	/**
	 * Retorno la lista de SolInfra cargadas en la BD
	 * 
	 * @return List<Servidor>
	 */
	public List<ComponenteSoftware> getListaSolInfra() {
		return componenteService.getComponentes(ComponenteSoftware.class);
	}

	public List<String> getTipos() {
		return componenteService.getTipos();
	}

	public String getViewUrl(ComponenteSoftware componente) {
		return "view" + componente.getClase() + ".xhtml?id=" + componente.getId();
	}

	public List<ComponenteSoftware> getFilteredComponentes() {
		return filteredComponentes;
	}

	public void setFilteredComponentes(List<ComponenteSoftware> filteredComponentes) {
		this.filteredComponentes = filteredComponentes;
	}
}
