package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;

import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.domain.StakeholdersComponente;
import uy.com.bse.soluciones.domain.Enumeradores.Rol;

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

	public StakeholderCompController() {

	}

	@PostConstruct
	public void init() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		stakeholderC = (StakeholdersComponente) sessionMap.get("stackeholdersComponente");
	}

	public StakeholdersComponente getStakeholderC() {
		return stakeholderC;
	}

	public void setStakeholderC(StakeholdersComponente stakeholderC) {
		this.stakeholderC = stakeholderC;
	}

	public void addStakeholderC() {
		// TODO Borrar cuando se seleccione un stakeholder desde la grilla.
		this.stakeholderC.getId().setStakeholderId(15L);
		PrimeFaces.current().dialog().closeDynamic(stakeholderC);
	}

	/**
	 * Retorna areglo con los valores del ENUM
	 * 
	 * @return
	 */
	public Rol[] getRolStakeholderCompValues() {
		return Rol.values();
	}

	public boolean isManaged(Long id) {
		return id != null;
	}
}
