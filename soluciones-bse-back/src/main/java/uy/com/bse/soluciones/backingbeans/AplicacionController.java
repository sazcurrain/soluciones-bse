package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import uy.com.bse.soluciones.domain.Aplicacion;
import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.domain.StakeholderType;
import uy.com.bse.soluciones.ejbs.AplicacionService;
import uy.com.bse.soluciones.ejbs.StakeholderService;

/**
 * Backing Bean de las pantallas de Persona
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("aplicacionController")
@ViewScoped
@Transactional
public class AplicacionController implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Aplicacion aplicacion = new Aplicacion();

	
	@EJB
	AplicacionService aplicacionService;
	
	
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
	 * @return List<Aplicacion>
	 */
	public List<Aplicacion> getListaAplicacion(){
		return aplicacionService.getAplicaciones();
		
	}
	
	/**
	 * Agrega una nueva aplicacion ala BD
	 * @return String con la regla de navegacion
	 */
	public String crearAplicacion() {
		aplicacionService.update(aplicacion);					
		return "aplicaciones.xhtml?faces-redirect=true";
	}
	
	/**
	 * Retorna areglo con los valores del ENUM
	 * @return
	 */
//	public StakeholderType[] getStakeholderTypes() {
//	   return  StakeholderType.values();
//	}

	/**
	 * Busca a una aplicacion por el ID
	 * Si la aplicacion existe en la BD retorna esa aplicacion
	 * En caso contrario crea una nueva
	 */
	public void findAplicacionById() {
		if (aplicacion.getId() != null) {
			aplicacion = aplicacionService.find(aplicacion.getId());
			for (Interfaz p : aplicacion.getProvee()) {
				System.out.println(p.getNombre());
			}
			if (aplicacion == null) {
				aplicacion = new Aplicacion();
			}
		}
	}
	
	public Set<Interfaz> getProvee() {
		return aplicacion.getProvee();
	}
	
	/**
	 * Elimina una aplicacion de la BD
	 * @param p
	 */
	public void eliminar(Aplicacion a) {
		aplicacionService.delete(a);
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
