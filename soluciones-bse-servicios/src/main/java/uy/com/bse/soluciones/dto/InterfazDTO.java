package uy.com.bse.soluciones.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import uy.com.bse.soluciones.adapter.DateAdapter;
import uy.com.bse.soluciones.domain.Aplicacion;
import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Enumeradores.TipoInterfaz;

@XmlRootElement(name = "interfaz")
public class InterfazDTO {
	
	private Long id;
	private String nombre;
	private String version;
	private Date fechaVersion;
	private TipoInterfaz tipo;
	
	
	public InterfazDTO() {
	}
	
	public static List<InterfazDTO> extracFromEntities(Set<Interfaz> interfaces) {
		List<InterfazDTO> newDTOs = new ArrayList<InterfazDTO>();
		for (Interfaz interfaz : interfaces) {
			InterfazDTO nueva = new InterfazDTO();
			nueva.setId(interfaz.getId());
			nueva.setNombre(interfaz.getNombre());
			nueva.setTipo(interfaz.getTipo());
			nueva.setVersion(interfaz.getVersion());
			nueva.setFechaVersion(interfaz.getFechaVersion());
			
			newDTOs.add(nueva);
		}
		
		return newDTOs;
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

	public TipoInterfaz getTipo() {
		return tipo;
	}

	public void setTipo(TipoInterfaz tipo) {
		this.tipo = tipo;
	}
}
