package uy.com.bse.soluciones.dto;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.xml.bind.annotation.XmlRootElement;

import uy.com.bse.soluciones.domain.ComponenteSoftware;

@XmlRootElement
public class ComponentesSoftwareDTO {
	private List<ComponenteSoftwareDTO> componentes = new ArrayList<ComponenteSoftwareDTO>();

	public ComponentesSoftwareDTO() {
		
	}
	
	private ComponenteSoftwareDTO convertEntity(ComponenteSoftware componente) {
		String className = this.getClass().getPackageName() + "." + componente.getClase() + "DTO";
		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> ctor = clazz.getConstructor(componente.getClass());
			ComponenteSoftwareDTO dto = (ComponenteSoftwareDTO)ctor.newInstance(new Object[] {componente});
			return dto;
		} catch (Exception e) {
			throw new WebApplicationException("Hubo un problema interno en la apĺicación. Su solicitud no pudo ser procesada.");
		} 
	}
	
	public ComponentesSoftwareDTO(List<ComponenteSoftware> componentes) {
		this.componentes = new ArrayList<ComponenteSoftwareDTO>();
		for (ComponenteSoftware componente : componentes) {
			ComponenteSoftwareDTO c = convertEntity(componente);
			this.componentes.add(c);
		}
	}
	
	public List<ComponenteSoftwareDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<ComponenteSoftwareDTO> componentes) {
		this.componentes = componentes;
	}
	
	

}
