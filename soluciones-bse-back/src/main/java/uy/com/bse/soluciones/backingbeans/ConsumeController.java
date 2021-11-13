package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
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
@Named("consumeController")
@ViewScoped
@Transactional
public class ConsumeController implements Serializable {
	@EJB
	InterfazService interfazService;
	

	private static final long serialVersionUID = 1L;
	
	
	public ConsumeController() {
		
	}
	
	public List<Interfaz> getListaInterfaces(){
		return interfazService.getInterfaces();
		
	}
	
	public void seleccionaInterfaz(Interfaz selected) {
		PrimeFaces.current().dialog().closeDynamic(selected);
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
