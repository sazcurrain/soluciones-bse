package uy.com.bse.soluciones.front.backingbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;

import uy.com.bse.soluciones.domain.Ambiente;
import uy.com.bse.soluciones.domain.SolInfra;
import uy.com.bse.soluciones.domain.Enumeradores.Entorno;
import uy.com.bse.soluciones.ejbs.AplicacionService;

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
	
	@EJB
	private AplicacionService aplicacionService;

	public AmbienteController() {

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

	@Transactional
	public void findAmbienteById() {
		if (ambiente.getId() != null) {
			ambiente = aplicacionService.findAmbienteByid(ambiente.getId());
			if (ambiente == null) {
				ambiente = new Ambiente();
			}
		}
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
