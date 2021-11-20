package uy.com.bse.soluciones.back.backingbeans;


import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;

import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Enumeradores.TipoInterfaz;
import uy.com.bse.soluciones.ejbs.InterfazService;

/**
 * Backing Bean de las pantallas de Persona
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("proveeController")
@ViewScoped
@Transactional
public class ProveeController implements Serializable {
	
	@EJB
	InterfazService interfazService;

	private static final long serialVersionUID = 1L;
	
	private Interfaz interfaz = new Interfaz();
	
	
	public ProveeController() {
		
	}
	
	@PostConstruct
	public void init() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        interfaz = (Interfaz) sessionMap.get("interfaz");
	}

	public Interfaz getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(Interfaz interfaz) {
		this.interfaz = interfaz;
	}
	
	public void addProvee() {
		PrimeFaces.current().dialog().closeDynamic(interfaz);
	}
	
	/**
	 * Retorna areglo con los valores del ENUM
	 * @return
	 */
	public TipoInterfaz[] getTipoInterfazValues() {
	   return  TipoInterfaz.values();
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
