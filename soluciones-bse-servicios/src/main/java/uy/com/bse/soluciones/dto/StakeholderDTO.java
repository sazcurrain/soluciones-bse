package uy.com.bse.soluciones.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.domain.Enumeradores.StakeholderType;

@XmlRootElement
public class StakeholderDTO {
	private Long id;
	private String nombre;
	private String mail;
	private String telefono;
	private StakeholderType tipo;
	
	
	public StakeholderDTO() {
	}
	
	public static StakeholderDTO adaptEntity(Stakeholder stakeholder) {
		StakeholderDTO newDTO = new StakeholderDTO();
		newDTO.setId(stakeholder.getId());
		newDTO.setNombre(stakeholder.getNombre());
		newDTO.setMail(stakeholder.getMail());
		newDTO.setTelefono(stakeholder.getTelefono());
		newDTO.setTipo(stakeholder.getTipo());
		
		return newDTO;
	}
	
	public static List<StakeholderDTO> adaptEntityList(List<Stakeholder> stakeholders) {
		List<StakeholderDTO> newDTOs = new ArrayList<StakeholderDTO>();
		for (Stakeholder stakeholder : stakeholders) {
			newDTOs.add(StakeholderDTO.adaptEntity(stakeholder));
		}
		return newDTOs;
	}
	
	public Stakeholder createEntity() {
		Stakeholder entity = new Stakeholder();
		entity.setId(this.getId());
		entity.setNombre(this.getNombre());
		entity.setMail(this.getMail());
		entity.setTelefono(this.getTelefono());
		entity.setTipo(this.getTipo());
		
		return entity;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public StakeholderType getTipo() {
		return tipo;
	}
	public void setTipo(StakeholderType tipo) {
		this.tipo = tipo;
	}

}
