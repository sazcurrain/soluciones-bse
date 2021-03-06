package uy.com.bse.soluciones.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import uy.com.bse.soluciones.domain.Enumeradores.Entorno;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SolInfra extends BaseEntity<Long> {

	/**
	 * hola mundo....
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String sistema_operativo;
	private String version;
	private Entorno entorno;
	private Set<Ambiente> ambientes= new HashSet<Ambiente>();
	
	@Id @GeneratedValue @Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	public String getSistema_operativo() {
		return sistema_operativo;
	}

	public void setSistema_operativo(String sistema_operativo) {
		this.sistema_operativo = sistema_operativo;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@OneToMany(mappedBy = "solInfra")
	public Set<Ambiente> getAmbientes() {
		return ambientes;
	}

	public SolInfra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAmbientes(Set<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

	@Enumerated
	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}
	
	@NotNull @Column(unique=true)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Transient
	public String getTipo() {
		return this.getClass().getSimpleName();
	}
}
