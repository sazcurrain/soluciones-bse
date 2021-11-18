package uy.com.bse.soluciones.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import uy.com.bse.soluciones.domain.Enumeradores.Rol;

@Entity

public class StakeholdersComponente extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private ComponenteSoftware componente;
	private Stakeholder stakeholder;
	private Rol rol;

	public StakeholdersComponente() {
	}


	@Id @GeneratedValue @Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@ManyToOne
	@JoinColumn(name = "componente_id")
	public ComponenteSoftware getComponente() {
		return componente;
	}

	public void setComponente(ComponenteSoftware componente) {
		this.componente = componente;
	}
	
	@ManyToOne
	@JoinColumn(name = "stakeholder_id")
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
