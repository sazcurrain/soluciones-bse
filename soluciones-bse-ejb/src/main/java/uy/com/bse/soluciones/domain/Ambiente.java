package uy.com.bse.soluciones.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;

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

	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getDirectorio() {
		return directorio;
	}

	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}

}
