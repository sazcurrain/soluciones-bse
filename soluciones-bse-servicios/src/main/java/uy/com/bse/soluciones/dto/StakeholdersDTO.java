package uy.com.bse.soluciones.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StakeholdersDTO {
	private List<StakeholderDTO> stakeholders = new ArrayList<StakeholderDTO>();

	public StakeholdersDTO() {
		
	}
	
	public StakeholdersDTO(List<StakeholderDTO> stakeholders) {
		this.stakeholders = stakeholders;
	}
	
	public List<StakeholderDTO> getStakeholders() {
		return stakeholders;
	}

	public void setStakeholders(List<StakeholderDTO> stakeholders) {
		this.stakeholders = stakeholders;
	}
	
	

}
