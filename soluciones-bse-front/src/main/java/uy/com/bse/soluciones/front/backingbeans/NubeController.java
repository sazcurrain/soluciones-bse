package uy.com.bse.soluciones.front.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.Nube;
import uy.com.bse.soluciones.domain.Enumeradores.Entorno;
import uy.com.bse.soluciones.ejbs.NubeService;

/**
 * Backing Bean de las pantallas de Nube
 * 
 * @author aem
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("nubeController")
@ViewScoped
public class NubeController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Nube nube = new Nube();

	@EJB
	NubeService nubeService;

	public NubeController() {

	}

	public Nube getNube() {
		return nube;
	}

	public void setNube(Nube nube) {
		this.nube = nube;
	}

	/**
	 * Retorno la lista de Nubes cargadas en la BD
	 * 
	 * @return List<Nube>
	 */
	public List<Nube> getListaNubes() {
		return nubeService.getNubes();

	}

	/**
	 * Agrega una nueva Nube ala BD
	 * 
	 * @return String con la regla de navegacion
	 */
	public String crearNube() {
		nubeService.update(nube);
		return "solsInfra.xhtml?faces-redirect=true";
	}

	/**
	 * Retorna arreglo con los valores del ENUM
	 * 
	 * @return
	 */
	public Entorno[] getEntornoValues() {
		return Entorno.values();
	}

	/**
	 * Busca a una Nube por el ID Si la Nube existe en la BD retorna esa Nube
	 * En caso contrario crea una nueva
	 */
	public void findNubeById() {
		if (nube.getId() != null) {
			nube = nubeService.find(nube.getId());
			if (nube == null) {
				nube = new Nube();
			}
		}
	}

	/**
	 * Elimina una Nube de la BD
	 * 
	 * @param p
	 */
	public void eliminar(Nube p) {
		nubeService.delete(p);
	}

	public boolean isManaged(Long id) {
		return id != null;
	}
}
