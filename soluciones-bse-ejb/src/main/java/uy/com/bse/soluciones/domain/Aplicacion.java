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
	private Set<Interface> provee = new HashSet<Interface>();
	private Set<Interface> consume = new HashSet<Interface>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicacion", orphanRemoval = true)
	public Set<Interface> getProvee() {
		return provee;
	}

	public void setProvee(Set<Interface> provee) {
		this.provee = provee;
	}
	
	@ManyToMany
	public Set<Interface> getConsume() {
		return consume;
	}

	public void setConsume(Set<Interface> consume) {
		this.consume = consume;
	}

	public Aplicacion() {
		super();
	}

}
