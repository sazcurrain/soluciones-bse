package uy.com.bse.soluciones.front.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.StakeholdersComponente;
import uy.com.bse.soluciones.ejbs.InterfazService;

/**
 * Backing Bean de las pantallas de Interfaz
 * 
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("interfazController")
@ViewScoped
public class InterfazController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Interfaz interfaz = new Interfaz();

	@EJB
	InterfazService interfazService;

	public InterfazController() {

	}

	public Interfaz getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(Interfaz interfaz) {
		this.interfaz = interfaz;
	}

	/**
	 * Retorno la lista de personas cargadas en la BD
	 * 
	 * @return List<Persona>
	 */
	public List<Interfaz> getListaInterfaces() {
		return interfazService.getInterfaces();

	}

	/**
	 * Busca a una interfaz por el ID Si la interfaz existe en la BD retorna esa
	 * interfaz En caso contrario crea una nueva
	 */
	@Transactional
	public void findInterfazById() {
		if (interfaz.getId() != null) {
			interfaz = interfazService.find(interfaz.getId());
			// Esto lo hacemos para que recorra las interfaces provistas y las instancie, ya
			// que están con fetch lazy, porque si trata de traerlas en el
			// xhtml, que no es transaccional, da un error.
			interfaz.getStakeholders().size();
			interfaz.getConsumidaPor().size();
			if (interfaz == null) {
				interfaz = new Interfaz();
			}
		}
	}

	public String getViewUrlStakeHolder(StakeholdersComponente stakeholdersC) {
		return "viewStakeholder.xhtml?id=" + stakeholdersC.getId();
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
