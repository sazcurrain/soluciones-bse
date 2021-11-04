package uy.com.bse.soluciones.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Solucion extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String descripcion;
	
	private Set<ComponenteSoftware> componentes = new HashSet<ComponenteSoftware>();
	
	public Solucion() {
		super();
	}

	@Id @GeneratedValue @Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@NotNull @Size(min=2, max=140) @Column(length=140)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
