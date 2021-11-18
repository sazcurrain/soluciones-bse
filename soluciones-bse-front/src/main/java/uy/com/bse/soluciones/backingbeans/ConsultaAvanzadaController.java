package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.time.temporal.Temporal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Enumeradores.TipoInterfaz;
import uy.com.bse.soluciones.ejbs.ComponenteSoftwareService;
import uy.com.bse.soluciones.ejbs.InterfazService;
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
	
	private String clase;

	public ConsultaAvanzadaController() {

	}
	
	public List<String> getTipos(){
		return componenteService.getTipos();
	}
	
	public TipoInterfaz[] getTiposInterfaz() {
		return TipoInterfaz.values();
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
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
}
