package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;

import uy.com.bse.soluciones.domain.Ambiente;
import uy.com.bse.soluciones.domain.SolInfra;
import uy.com.bse.soluciones.domain.Enumeradores.Entorno;

/**
 * Backing Bean de las pantallas de Persona
 * 
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("ambienteController")
@ViewScoped
@Transactional
public class AmbienteController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ambiente ambiente = new Ambiente();

	public AmbienteController() {

	}

	@PostConstruct
	public void init() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		ambiente = (Ambiente) sessionMap.get("ambiente");
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public void seleccionaAmbiente(SolInfra solInfra) {
		this.ambiente.setSolInfra(solInfra);
		PrimeFaces.current().dialog().closeDynamic(ambiente);
	}

	/**
	 * Retorna areglo con los valores del ENUM
	 * 
	 * @return
	 */
	public Entorno[] getEntornoValues() {
		return Entorno.values();
	}

	public boolean isManaged(Long id) {
		return id != null;
	}
}
