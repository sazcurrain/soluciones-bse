package uy.com.bse.soluciones.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import uy.com.bse.soluciones.adapter.DateAdapter;
import uy.com.bse.soluciones.domain.Aplicacion;

@XmlRootElement(name = "aplicacion")
public class AplicacionDTO {
	private Long id;
	private String nombre;
	private String version;
	private Date fechaVersion;
	private List<InterfazDTO> provee = new ArrayList<InterfazDTO>();
	private List<InterfazDTO> consume = new ArrayList<InterfazDTO>();

	public static AplicacionDTO adaptEntity(Aplicacion app) {
		List<InterfazDTO> provee = InterfazDTO.extracFromEntities(app.getProvee());
		List<InterfazDTO> consume = InterfazDTO.extracFromEntities(app.getConsume());
		AplicacionDTO dto = new AplicacionDTO();
		dto.setId(app.getId());
		dto.setNombre(app.getNombre());
		dto.setVersion(app.getVersion());
		dto.setFechaVersion(app.getFechaVersion());
		dto.setProvee(provee);
		dto.setConsume(consume);
		return dto;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getFechaVersion() {
		return fechaVersion;
	}

	public void setFechaVersion(Date fechaVersion) {
		this.fechaVersion = fechaVersion;
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
