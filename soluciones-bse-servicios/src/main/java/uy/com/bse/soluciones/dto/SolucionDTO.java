package uy.com.bse.soluciones.dto;

import javax.xml.bind.annotation.XmlRootElement;

import uy.com.bse.soluciones.domain.Solucion;

@XmlRootElement(name = "aplicacion")
public class SolucionDTO extends ComponenteSoftwareDTO{
	private String descripcion;
	
	public SolucionDTO() {};

	public SolucionDTO(Solucion solucion) {
		this.setId(solucion.getId());
		this.setNombre(solucion.getNombre());
		this.setVersion(solucion.getVersion());
		this.setFechaVersion(solucion.getFechaVersion());
		this.setClase(solucion.getClase());
		this.setDescripcion(solucion.getDescripcion());
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
