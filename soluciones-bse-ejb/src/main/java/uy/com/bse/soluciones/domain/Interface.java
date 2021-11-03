package uy.com.bse.soluciones.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Interface extends ComponenteSoftware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aplicacion aplicacion;

	public Interface() {
		super();
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}
