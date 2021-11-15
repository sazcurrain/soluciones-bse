package uy.com.bse.soluciones.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import uy.com.bse.soluciones.domain.Enumeradores.Rol;

@Entity

public class StakeholdersComponente {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private StakeholderComponenteId id;
	private ComponenteSoftware componente;
	private Stakeholder stakeholder;
	private Rol rol;

	public StakeholdersComponente() {
		this.id = new StakeholderComponenteId();
	}


	@EmbeddedId
	public StakeholderComponenteId getId() {
		return id;
	}



	public void setId(StakeholderComponenteId id) {
		this.id = id;
	}



	@ManyToOne
	@JoinColumn(name = "componente_id", insertable = false, updatable = false)
	public ComponenteSoftware getComponente() {
		return componente;
	}

	public void setComponente(ComponenteSoftware componente) {
		this.componente = componente;
	}
	
	@ManyToOne
	@JoinColumn(name = "stakeholder_id", insertable = false, updatable = false)
	public Stakeholder getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(Stakeholder stakeholder) {
		this.stakeholder = stakeholder;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

}
