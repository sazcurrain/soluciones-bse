package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.Tienda;
import uy.com.bse.soluciones.domain.Enumeradores.Entorno;
import uy.com.bse.soluciones.ejbs.TiendaService;

/**
 * Backing Bean de las pantallas de Tienda
 * 
 * @author aem
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("tiendaController")
@ViewScoped
public class TiendaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Tienda tienda = new Tienda();

	@EJB
	TiendaService tiendaService;

	public TiendaController() {

	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	/**
	 * Retorno la lista de Tiendas cargadas en la BD
	 * 
	 * @return List<Tienda>
	 */
	public List<Tienda> getListaTiendas() {
		return tiendaService.getTiendas();

	}

	/**
	 * Agrega una nueva Tienda ala BD
	 * 
	 * @return String con la regla de navegacion
	 */
	public String crearTienda() {
		tiendaService.update(tienda);
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
	 * Busca a una Tienda por el ID Si la Tienda existe en la BD retorna esa Tienda
	 * En caso contrario crea una nueva
	 */
	public void findTiendaById() {
		if (tienda.getId() != null) {
			tienda = tiendaService.find(tienda.getId());
			if (tienda == null) {
				tienda = new Tienda();
			}
		}
	}

	/**
	 * Elimina una Tienda de la BD
	 * 
	 * @param p
	 */
	public void eliminar(Tienda p) {
		tiendaService.delete(p);
	}

	public boolean isManaged(Long id) {
		return id != null;
	}
}
