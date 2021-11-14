package uy.com.bse.soluciones.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ComponenteSoftware extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String version;
	private Date fechaVersion;
	private Set<StakeholdersComponente> stakeholders;
	
	@Id @GeneratedValue @Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Past @NotNull @Temporal(TemporalType.DATE)
	public Date getFechaVersion() {
		return fechaVersion;
	}

	public void setFechaVersion(Date fechaVersion) {
		this.fechaVersion = fechaVersion;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<StakeholdersComponente> getStakeholders() {
		return stakeholders;
	}

	public void setStakeholders(Set<StakeholdersComponente> stakeholders) {
		this.stakeholders = stakeholders;
	}
	
	
	public void addStakeholders(StakeholdersComponente skate) {
		this.getStakeholders().add(skate);
	}
	
	public void removeStakeholders(StakeholdersComponente skate) {
		if(this.getStakeholders().contains(skate)) {
			this.getStakeholders().remove(skate);
		}
	}
	
	
	@Transient
	public String getClase() {
		return this.getClass().getSimpleName();
	}
}
