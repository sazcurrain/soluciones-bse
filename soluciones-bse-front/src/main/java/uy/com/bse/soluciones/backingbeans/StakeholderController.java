package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.domain.StakeholderType;
import uy.com.bse.soluciones.ejbs.StakeholderService;

/**
 * Backing Bean de las pantallas de Persona
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("stakeholderController")
@ViewScoped
public class StakeholderController implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Stakeholder stakeholder = new Stakeholder();

	
	@EJB
	StakeholderService stakeholderService;
	
	
	public StakeholderController() {
		
	}

	public Stakeholder getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(Stakeholder stakeholder) {
		this.stakeholder = stakeholder;
	}
	
	/**
	 * Retorno la lista de Stakeholders cargadas en la BD
	 * @return List<Stakeholder>
	 */
	public List<Stakeholder> getListaStakeholder(){
		return stakeholderService.getStakeholders();
		
	}
	
	/**
	 * Agrega una nueva persona ala BD
	 * @return String con la regla de navegacion
	 */
	public String crearStakeholder() {
		stakeholderService.update(stakeholder);					
		return "stakeholders.xhtml?faces-redirect=true";
	}
	
	/**
	 * Retorna areglo con los valores del ENUM
	 * @return
	 */
	public StakeholderType[] getStakeholderTypes() {
	   return  StakeholderType.values();
	}

	/**
	 * Busca a una persona por el ID
	 * Si la persona existe en la BD retorna esa persona
	 * En caso contrario crea una nueva
	 */
	public void findStakeholderById() {
		if (stakeholder.getId() != null) {
			stakeholder = stakeholderService.find(stakeholder.getId());
			if (stakeholder == null) {
				stakeholder = new Stakeholder();
			}
		}
	}
	
	/**
	 * Elimina una persona de la BD
	 * @param p
	 */
	public void eliminar(Stakeholder p) {
		stakeholderService.delete(p);
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
