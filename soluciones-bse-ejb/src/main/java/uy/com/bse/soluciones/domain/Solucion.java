package uy.com.bse.soluciones.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Solucion extends ComponenteSoftware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private Set<ComponenteSoftware> componentes = new HashSet<ComponenteSoftware>();
	
	public Solucion() {
		super();
	}

	@Size(min=2, max=2048)  @Column(length=2048)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToMany
	public Set<ComponenteSoftware> getComponentes() {
		return componentes;
	}

	public void setComponentes(Set<ComponenteSoftware> componentes) {
		this.componentes = componentes;
	}

}
