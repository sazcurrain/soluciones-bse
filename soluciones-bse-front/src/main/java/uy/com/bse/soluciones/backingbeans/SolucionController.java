package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import uy.com.bse.soluciones.domain.Solucion;
import uy.com.bse.soluciones.ejbs.SolucionService;

/**
 * Backing Bean de las pantallas de consulta simple
 * @author aem
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("solucionController")
@ViewScoped
public class SolucionController implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Solucion solucion = new Solucion();

	
	@EJB
	SolucionService SolucionService;
	
	//@EJB
	//AplicacionService aplicacionService;
	
	//@EJB
	//InterfazService interfazService;
	
	
	public SolucionController() {
		
	}

	public Solucion getSolucion() {
		return solucion;
	}

	public void setSolucion(Solucion solucion) {
		this.solucion = solucion;
	}
	
	/**
	 * Retorno la lista de Solucion cargadas en la BD
	 * @return List<Solucion>
	 */
	public List<Solucion> getListaSolucion(){
		return SolucionService.getSoluciones();
		
	}

	/**
	 * Busca a una solucion por el ID
	 * Si la solucion existe en la BD retorna esa solucion
	 * En caso contrario crea una nueva
	 */

	@Transactional
	public void findSolucionById() {
		if (solucion.getId() != null) {
			solucion = SolucionService.find(solucion.getId());
			//Esto lo hacemos para que recorra las interfaces provistas y las instancie, ya que están con fetch lazy, porque si trata de traerlas en el 
			//xhtml, que no es transaccional, da un error.
			solucion.getComponentes().size();
			solucion.getStakeholders().size();
			if (solucion == null) {
				solucion = new Solucion();
			}
		}
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}