package uy.com.bse.soluciones.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StakeholderComponenteId implements Serializable {

	protected Long componenteId;
	protected Long stakeholderId;

	public StakeholderComponenteId() {

	}

	@Column(name = "componente_id")
	public Long getComponenteId() {
		return componenteId;
	}

	public void setComponenteId(Long componenteId) {
		this.componenteId = componenteId;
	}

	@Column(name = "stakeholder_id")
	public Long getStakeholderId() {
		return stakeholderId;
	}

	public void setStakeholderId(Long stakeholderId) {
		this.stakeholderId = stakeholderId;
	}

	public StakeholderComponenteId(Long componenteId, Long stakeholderId) {
		this.componenteId = componenteId;
		this.stakeholderId = stakeholderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componenteId == null) ? 0 : componenteId.hashCode());
		result = prime * result + ((stakeholderId == null) ? 0 : stakeholderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		StakeholderComponenteId other = (StakeholderComponenteId) obj;

		if (componenteId == null) {
			if (other.componenteId != null)
				return false;
		} else if (!componenteId.equals(other.componenteId))
			return false;

		if (stakeholderId == null) {
			if (other.stakeholderId != null)
				return false;
		} else if (!stakeholderId.equals(other.stakeholderId))
			return false;

		return true;
	}
}
