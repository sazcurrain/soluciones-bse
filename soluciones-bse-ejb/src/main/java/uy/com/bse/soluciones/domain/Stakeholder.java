package uy.com.bse.soluciones.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import uy.com.bse.soluciones.domain.Enumeradores.StakeholderType;


@Entity
public class Stakeholder extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String mail;
	private String telefono;
	private StakeholderType tipo;
	private Set<StakeholdersComponente> componentes;

	public Stakeholder() {
		// TODO Auto-generated constructor stub
	}

	@Id @GeneratedValue @Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@NotNull @Size(min = 2, max = 140)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Email
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Size(min=7, max=16)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@NotNull
	public StakeholderType getTipo() {
		return tipo;
	}

	public void setTipo(StakeholderType tipo) {
		this.tipo = tipo;
	}
	
	@OneToMany(mappedBy = "stakeholder")
	public Set<StakeholdersComponente> getComponentes() {
		return componentes;
	}

	public void setComponentes(Set<StakeholdersComponente> componentes) {
		this.componentes = componentes;
	}
	
	

}
