package uy.com.bse.soluciones.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Nube extends SolInfra {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url;

	public Nube() {
		// TODO Auto-generated constructor stub
		super();
	}

	@NotNull
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
