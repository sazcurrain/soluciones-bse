package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.StakeholdersComponente;
import uy.com.bse.soluciones.ejbs.InterfazService;

/**
 * Backing Bean de las pantallas de Interfaz
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
	 * @return List<Persona>
	 */
	public List<Interfaz> getListaInterfaces(){
		return interfazService.getInterfaces();
		
	}
	
		/**
	 * Agrega una nueva interfaz ala BD
	 * @return String con la regla de navegacion
	 */
	public String crearInterfaz() {
		interfazService.update(interfaz);					
		return "interfaces.xhtml?faces-redirect=true";
	}
	
	/**
	 * Busca a una interfaz por el ID
	 * Si la interfaz existe en la BD retorna esa interfaz
	 * En caso contrario crea una nueva
	 */
	@Transactional
	public void findInterfazById() {
		if (interfaz.getId() != null) {
			interfaz = interfazService.find(interfaz.getId());
			interfaz.getStakeholders().size();
			if (interfaz == null) {
				interfaz = new Interfaz();
			}
		}
	}
	
	/**
	 * Elimina una interfaz de la BD
	 * @param p
	 */
	public void eliminar(Interfaz i) {
		interfazService.delete(i);
	}
	
	public void eliminarStakeholder(StakeholdersComponente s) {
		interfaz.removeStakeholders(s);
	}
	
	public void onAddSkateholder(SelectEvent<StakeholdersComponente> event) {
		StakeholdersComponente nueva = event.getObject();
		nueva.setComponente(interfaz);
		interfaz.addStakeholders(nueva);
	}
	
	public void onEditSkateholder(SelectEvent<StakeholdersComponente> event) {
	}

	public void addStakeholdersComponente() {
		
		Map<String, Object> options = new HashMap<>();
		options.put("modal", true);
		options.put("width", 980);
		options.put("height", 440);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("stakeholdersComponente", new StakeholdersComponente());
		PrimeFaces.current().dialog().openDynamic("altaStakeholdersComponenteDialog", options, null);
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
