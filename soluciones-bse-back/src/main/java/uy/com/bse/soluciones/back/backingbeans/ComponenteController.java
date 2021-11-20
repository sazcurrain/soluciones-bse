package uy.com.bse.soluciones.back.backingbeans;


import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;

import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.ejbs.ComponenteSoftwareService;

/**
 * Backing Bean de las pantallas de Componentes
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("componenteController")
@ViewScoped
@Transactional
public class ComponenteController implements Serializable {
	@EJB
	ComponenteSoftwareService componenteService;
	

	private static final long serialVersionUID = 1L;
	
	
	public ComponenteController() {
		
	}
	
	public List<ComponenteSoftware> getListaComponentes(){
		return componenteService.getComponentes(ComponenteSoftware.class);
		
	}
	
	public void seleccionaComponente(ComponenteSoftware selected) {
		PrimeFaces.current().dialog().closeDynamic(selected);
    }
	/**
	 * Retorna areglo con los valores del ENUM
	 * @return
	 */
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
