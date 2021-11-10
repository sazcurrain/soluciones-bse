package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;

import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.domain.StakeholderType;
import uy.com.bse.soluciones.ejbs.StakeholderService;

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
	

	private static final long serialVersionUID = 1L;
	
	private Interfaz interfaz = new Interfaz();
	
	
	public ProveeController() {
		
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
	 * Busca a una interfaz por el ID
	 * Si la interfaz existe en la BD retorna esa interfaz
	 * En caso contrario crea una nueva
	 */
	public void findInterfazById() {
		/*if (interfaz.getId() != null) {
			interfaz = interfazService.find(interfaz.getId());
			for (Interfaz p : interfaz.getProvee()) {
				System.out.println(p.getNombre());
			}
			if (interfaz == null) {
				interfaz = new Interfaz();
			}
		}*/
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
