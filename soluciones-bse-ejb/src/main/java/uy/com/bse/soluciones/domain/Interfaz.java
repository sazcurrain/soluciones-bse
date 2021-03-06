package uy.com.bse.soluciones.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import uy.com.bse.soluciones.domain.Enumeradores.Aplicacion_Implementacion;
import uy.com.bse.soluciones.domain.Enumeradores.TipoInterfaz;

@Entity
public class Interfaz extends ComponenteSoftware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TipoInterfaz tipo;
	private Aplicacion aplicacion;
	private Set<Aplicacion>  consumidaPor;
	private Aplicacion_Implementacion Implementacion;

	public Interfaz() {
		super();
	}
	
	@ManyToMany(mappedBy = "consume")
	public Set<Aplicacion> getConsumidaPor() {
		return consumidaPor;
	}

	public void setConsumidaPor(Set<Aplicacion> consumidaPor) {
		this.consumidaPor = consumidaPor;
	}
	
	@ManyToOne
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

	public TipoInterfaz getTipo() {
		return tipo;
	}

	public void setTipo(TipoInterfaz tipo) {
		this.tipo = tipo;
	}

}
