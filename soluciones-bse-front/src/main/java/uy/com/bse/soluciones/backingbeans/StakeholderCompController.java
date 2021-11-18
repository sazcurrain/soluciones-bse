package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import uy.com.bse.soluciones.domain.StakeholdersComponente;
import uy.com.bse.soluciones.domain.Enumeradores.Rol;
import uy.com.bse.soluciones.ejbs.ComponenteSoftwareService;

/**
 * Backing Bean de las pantallas de Persona
 * 
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("stakeholderCompController")
@ViewScoped
@Transactional
public class StakeholderCompController implements Serializable {

	private static final long serialVersionUID = 1L;

	private StakeholdersComponente stakeholderC = new StakeholdersComponente();

	@EJB
	private ComponenteSoftwareService compSoftService;
	
	public StakeholderCompController() {

	}

	public StakeholdersComponente getStakeholderC() {
		return stakeholderC;
	}

	public void setStakeholderC(StakeholdersComponente stakeholderC) {
		this.stakeholderC = stakeholderC;
	}

	/**
	 * Retorna areglo con los valores del ENUM
	 * 
	 * @return
	 */
	public Rol[] getRolStakeholderCompValues() {
		return Rol.values();
	}

	@Transactional
	public void findSolucionCompById() {
		if (stakeholderC.getId() != null) {
			stakeholderC = compSoftService.findStakeholderCompByid(stakeholderC.getId());
			if (stakeholderC == null) {
				stakeholderC = new StakeholdersComponente();
			}
		}
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
