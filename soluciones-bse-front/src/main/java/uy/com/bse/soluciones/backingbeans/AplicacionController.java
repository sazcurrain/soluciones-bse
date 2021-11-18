package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import uy.com.bse.soluciones.domain.Ambiente;
import uy.com.bse.soluciones.domain.Aplicacion;
import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.StakeholdersComponente;
import uy.com.bse.soluciones.ejbs.AplicacionService;

/**
 * Backing Bean de las pantallas de Persona
 * 
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("aplicacionController")
@ViewScoped
public class AplicacionController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aplicacion aplicacion = new Aplicacion();

	@EJB
	AplicacionService aplicacionService;

	// @EJB
	// InterfazService interfazService;

	public AplicacionController() {

	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	/**
	 * Retorno la lista de Aplicacion cargadas en la BD
	 * 
	 * @return List<Aplicacion>
	 */
	public List<Aplicacion> getListaAplicacion() {
		return aplicacionService.getAplicaciones();

	}

	/**
	 * Busca a una aplicacion por el ID Si la aplicacion existe en la BD retorna esa
	 * aplicacion En caso contrario crea una nueva
	 */

	@Transactional
	public void findAplicacionById() {
		if (aplicacion.getId() != null) {
			aplicacion = aplicacionService.find(aplicacion.getId());
			// Esto lo hacemos para que recorra las interfaces provistas y las instancie, ya
			// que están con fetch lazy, porque si trata de traerlas en el
			// xhtml, que no es transaccional, da un error.
			aplicacion.getProvee().size();
			aplicacion.getConsume().size();
			aplicacion.getStakeholders().size();
			aplicacion.getAmbientes().size();
			if (aplicacion == null) {
				aplicacion = new Aplicacion();
			}
		}
	}

	public String getViewUrlInterfaz(Interfaz interfaz) {
		return "viewInterfaz.xhtml?id=" + interfaz.getId();
	}

	public String getViewUrlStakeHolder(StakeholdersComponente stakeholdersC) {
		return "viewStakeholder.xhtml?id=" + stakeholdersC.getId();
	}

	public String getViewUrlAmbiente(Ambiente ambiente) {
		switch (ambiente.getSolInfra().getClass().getSimpleName()) {
		case "Cluster":
			return "viewAmbienteCluster.xhtml?ambienteId=" + ambiente.getId() + "&clusterId="
					+ ambiente.getSolInfra().getId();
		case "Nube":
			return "viewAmbienteNube.xhtml?ambienteId=" + ambiente.getId() + "&nubeId="
					+ ambiente.getSolInfra().getId();
		case "Servidor":
			return "viewAmbienteServidor.xhtml?ambienteId=" + ambiente.getId() + "&servidorId="
					+ ambiente.getSolInfra().getId();
		case "Tienda":
			return "viewAmbienteTienda.xhtml?ambienteId=" + ambiente.getId() + "&tiendaId="
					+ ambiente.getSolInfra().getId();
		  default:
			  return null;
		}
		
	}

	public boolean isManaged(Long id) {
		return id != null;
	}
}
