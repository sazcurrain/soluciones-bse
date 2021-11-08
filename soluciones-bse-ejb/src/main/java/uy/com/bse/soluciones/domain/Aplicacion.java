package uy.com.bse.soluciones.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Aplicacion extends ComponenteSoftware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Interfaz> provee = new HashSet<Interfaz>();
	private Set<Interfaz> consume = new HashSet<Interfaz>();
	private Set<Ambiente> ambientes= new HashSet<Ambiente>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicacion", orphanRemoval = true)
	public Set<Interfaz> getProvee() {
		return provee;
	}

	public void setProvee(Set<Interfaz> provee) {
		this.provee = provee;
	}
	
	@ManyToMany
	public Set<Interfaz> getConsume() {
		return consume;
	}

	public void setConsume(Set<Interfaz> consume) {
		this.consume = consume;
	}

	public Aplicacion() {
		super();
	}

	
	@OneToMany(mappedBy = "aplicacion")
	public Set<Ambiente> getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(Set<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

}
