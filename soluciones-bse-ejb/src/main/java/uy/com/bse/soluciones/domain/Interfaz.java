package uy.com.bse.soluciones.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import uy.com.bse.soluciones.domain.Enumeradores.Aplicacion_Implementacion;

@Entity
public class Interfaz extends ComponenteSoftware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aplicacion aplicacion;
	private Aplicacion_Implementacion Implementacion;

	public Interfaz() {
		super();
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public Interfaz(Aplicacion aplicacion) {
		super();
		this.aplicacion = aplicacion;
	}

	public Aplicacion_Implementacion getImplementacion() {
		return Implementacion;
	}

	public void setImplementacion(Aplicacion_Implementacion implementacion) {
		Implementacion = implementacion;
	}

}