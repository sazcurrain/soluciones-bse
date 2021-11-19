package uy.com.bse.soluciones.dto;


import javax.xml.bind.annotation.XmlRootElement;

import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Enumeradores.TipoInterfaz;

@XmlRootElement(name = "interfaz")
public class InterfazDTO extends ComponenteSoftwareDTO{
	private TipoInterfaz tipo;
	
	
	public InterfazDTO() {
	}
	
	public InterfazDTO(Interfaz interfaz) {
		this.setId(interfaz.getId());
		this.setNombre(interfaz.getNombre());
		this.setTipo(interfaz.getTipo());
		this.setVersion(interfaz.getVersion());
		this.setFechaVersion(interfaz.getFechaVersion());
		this.setClase(interfaz.getClase());
	}

	public TipoInterfaz getTipo() {
		return tipo;
	}

	public void setTipo(TipoInterfaz tipo) {
		this.tipo = tipo;
	}
}
