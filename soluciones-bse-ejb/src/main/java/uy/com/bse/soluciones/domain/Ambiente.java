package uy.com.bse.soluciones.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PositiveOrZero;

import uy.com.bse.soluciones.domain.Enumeradores.Entorno;

@Entity
public class Ambiente extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Entorno entorno;
	private int puerto;
	private String url;
	private String directorio;
	private Aplicacion aplicacion;
	private SolInfra solInfra;

	@ManyToOne
	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@ManyToOne
	public SolInfra getSolInfra() {
		return solInfra;
	}

	public void setSolInfra(SolInfra solInfra) {
		this.solInfra = solInfra;
	}

	public Ambiente() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Id
	@GeneratedValue
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@PositiveOrZero
	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	@Enumerated
	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDirectorio() {
		return directorio;
	}

	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}

}
