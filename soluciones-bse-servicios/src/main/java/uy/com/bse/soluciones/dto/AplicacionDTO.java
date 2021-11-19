package uy.com.bse.soluciones.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import uy.com.bse.soluciones.domain.Aplicacion;
import uy.com.bse.soluciones.domain.Interfaz;

@XmlRootElement(name = "aplicacion")
public class AplicacionDTO extends ComponenteSoftwareDTO{
	private List<InterfazDTO> provee = new ArrayList<InterfazDTO>();
	private List<InterfazDTO> consume = new ArrayList<InterfazDTO>();
	
	public AplicacionDTO() {};
	
	private List<InterfazDTO> convertEntities(Set<Interfaz> interfaces) {
		List<InterfazDTO> dtos = new ArrayList<InterfazDTO>();
		for (Interfaz interfaz : interfaces) {
			dtos.add(new InterfazDTO(interfaz));
		}
		return dtos;
	}

	public AplicacionDTO(Aplicacion app) {
		List<InterfazDTO> provee = convertEntities(app.getProvee());
		List<InterfazDTO> consume = convertEntities(app.getConsume());
		this.setId(app.getId());
		this.setNombre(app.getNombre());
		this.setVersion(app.getVersion());
		this.setFechaVersion(app.getFechaVersion());
		this.setClase(app.getClase());
		this.setProvee(provee);
		this.setConsume(consume);
	}

	public List<InterfazDTO> getProvee() {
		return provee;
	}
	
	@XmlElementRef
	@XmlElementWrapper(name = "provee")
	public void setProvee(List<InterfazDTO> provee) {
		this.provee = provee;
	}

	@XmlElementRef
	@XmlElementWrapper(name = "consume")
	public List<InterfazDTO> getConsume() {
		return consume;
	}

	public void setConsume(List<InterfazDTO> consume) {
		this.consume = consume;
	}

	public void addProvee(InterfazDTO inter) {
		this.getProvee().add(inter);
	}

	public void removeProvee(InterfazDTO inter) {
		if (this.getProvee().contains(inter)) {
			this.getProvee().remove(inter);
		}
	}

	public void addConsume(InterfazDTO inter) {
		this.getConsume().add(inter);
	}

	public void removeConsume(InterfazDTO inter) {
		if (this.getConsume().contains(inter)) {
			this.getConsume().remove(inter);
		}
	}

}
