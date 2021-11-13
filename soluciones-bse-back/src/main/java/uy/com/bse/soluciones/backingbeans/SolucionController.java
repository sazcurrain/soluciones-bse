package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.Solucion;
import uy.com.bse.soluciones.ejbs.SolucionService;

/**
 * Backing Bean de las pantallas de Solucion
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("solucionController")
@ViewScoped
public class SolucionController implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Solucion solucion = new Solucion();

	
	@EJB
	SolucionService solucionService;
	
	
	public SolucionController() {
		
	}

	public Solucion getSolucion() {
		return solucion;
	}

	public void setSolucion(Solucion solucion) {
		this.solucion = solucion;
	}
	
	/**
	 * Retorno la lista de personas cargadas en la BD
	 * @return List<Persona>
	 */
	public List<Solucion> getListaSoluciones(){
		return solucionService.getSoluciones();
		
	}
	
		/**
	 * Agrega una nueva solucion ala BD
	 * @return String con la regla de navegacion
	 */
	public String crearSolucion() {
		solucionService.update(solucion);					
		return "soluciones.xhtml?faces-redirect=true";
	}
	
	/**
	 * Busca a una solucion por el ID
	 * Si la solucion existe en la BD retorna esa solucion
	 * En caso contrario crea una nueva
	 */
	public void findSolucionById() {
		if (solucion.getId() != null) {
			solucion = solucionService.find(solucion.getId());
			if (solucion == null) {
				solucion = new Solucion();
			}
		}
	}
	
	/**
	 * Elimina una solucion de la BD
	 * @param p
	 */
	public void eliminar(Solucion i) {
		solucionService.delete(i);
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
