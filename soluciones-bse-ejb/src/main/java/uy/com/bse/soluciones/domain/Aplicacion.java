<<<<<<< HEAD
package uy.com.bse.soluciones.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	//private Set<Ambiente> ambientes= new HashSet<Ambiente>();
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "aplicacion", cascade = CascadeType.ALL)
	public Set<Interfaz> getProvee() {
		return provee;
	}

	public void setProvee(Set<Interfaz> provee) {
		this.provee = provee;
	}
	
	@ManyToMany
	@JoinTable(name="app_consume_inter",joinColumns= @JoinColumn(name="app_fk"),inverseJoinColumns = @JoinColumn(name="inter_fk"))
	public Set<Interfaz> getConsume() {
		return consume;
	}

	public void setConsume(Set<Interfaz> consume) {
		this.consume = consume;
	}
	
	public void addProvee(Interfaz inter) {
		this.getProvee().add(inter);
	}
	
	public void removeProvee(Interfaz inter) {
		if(this.getProvee().contains(inter)) {
			this.getProvee().remove(inter);
		}
	}
	
	public void addConsume(Interfaz inter) {
		this.getConsume().add(inter);
	}
	
	public void removeConsume(Interfaz inter) {
		if(this.getConsume().contains(inter)) {
			this.getConsume().remove(inter);
		}
	}

	public Aplicacion() {
		super();
	}

	
//	@OneToMany(mappedBy = "aplicacion")
//	public Set<Ambiente> getAmbientes() {
//		return ambientes;
//	}
//
//	public void setAmbientes(Set<Ambiente> ambientes) {
//		this.ambientes = ambientes;
//	}

}
=======
package uy.com.bse.soluciones.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	//private Set<Ambiente> ambientes= new HashSet<Ambiente>();
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "aplicacion", cascade = CascadeType.ALL)
	public Set<Interfaz> getProvee() {
		return provee;
	}

	public void setProvee(Set<Interfaz> provee) {
		this.provee = provee;
	}
	
	@ManyToMany
	@JoinTable(name="app_consume_inter",joinColumns= @JoinColumn(name="app_fk"),inverseJoinColumns = @JoinColumn(name="inter_fk"))
	public Set<Interfaz> getConsume() {
		return consume;
	}

	public void setConsume(Set<Interfaz> consume) {
		this.consume = consume;
	}
	
	public void addProvee(Interfaz inter) {
		this.getProvee().add(inter);
	}
	
	public void removeProvee(Interfaz inter) {
		if(this.getProvee().contains(inter)) {
			this.getProvee().remove(inter);
		}
	}
	
	public void addConsume(Interfaz inter) {
		this.getConsume().add(inter);
	}
	
	public void removeConsume(Interfaz inter) {
		if(this.getConsume().contains(inter)) {
			this.getConsume().remove(inter);
		}
	}

	public Aplicacion() {
		super();
	}

	
//	@OneToMany(mappedBy = "aplicacion")
//	public Set<Ambiente> getAmbientes() {
//		return ambientes;
//	}
//
//	public void setAmbientes(Set<Ambiente> ambientes) {
//		this.ambientes = ambientes;
//	}

}
>>>>>>> branch 'dev' of https://github.com/sazcurrain/soluciones-bse.git
