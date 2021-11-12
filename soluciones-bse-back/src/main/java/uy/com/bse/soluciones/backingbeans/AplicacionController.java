package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import uy.com.bse.soluciones.domain.Aplicacion;
import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.domain.StakeholderType;
import uy.com.bse.soluciones.ejbs.AplicacionService;
import uy.com.bse.soluciones.ejbs.InterfazService;
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
	
	@EJB
	InterfazService interfazService;
	
	
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
	 * Retorna are
	 * 
	 * 
	 * glo con los valores del ENUM
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
			//Esto lo hacemos para que recorra las interfaces provistas y las instancie, ya que están con fetch lazy, porque si trata de traerlas en el 
			//xhtml, que no es transaccional, da un error.
			aplicacion.getProvee().toArray();
			aplicacion.getConsume().toArray();
			if (aplicacion == null) {
				aplicacion = new Aplicacion();
			}
		}
	}
	
	/*public Set<Interfaz> getProvee() {
		return aplicacion.getProvee();
	}*/
	
	/**
	 * Elimina una aplicacion de la BD
	 * @param p
	 */
	public void eliminar(Aplicacion a) {
		aplicacionService.delete(a);
	}
	
	public void eliminarProvee(Interfaz i) {
		aplicacion.removeProvee(i);
	}
	
	public void eliminarConsume(Interfaz i) {
		aplicacion.removeConsume(i);
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
	
	//TODO aem -- hacer para consume
	public void addInterConsume() {
		Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
     // TODO REVISAR CON SERGIO ESTOS 3 RENGLONES
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		/* sessionMap.entrySet("interfaz", interfazService.getSetInterfaces()); */
        sessionMap.put("interfaz", new Interfaz());
        PrimeFaces.current().dialog().openDynamic("altaInterConsumeDialog", options, null);
	}
	
	public void addInterProvee() {
		Map<String, Object> options = new HashMap<>();
		options.put("modal", true);
        options.put("width", 640);
        options.put("height", 440);
        options.put("contentWidth", "150%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("interfaz", new Interfaz());
        PrimeFaces.current().dialog().openDynamic("altaInterProveeDialog", options, null);
	}
	

	public void editInterProvee(Interfaz i) {
		Map<String, Object> options = new HashMap<>();
		options.put("modal", true);
        options.put("width", 640);
        options.put("height", 440);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
        
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("interfaz", i);
        PrimeFaces.current().dialog().openDynamic("altaInterProveeDialog", options, null);
	}
	
	public void onAddProvee(SelectEvent<Interfaz> event) {
		Interfaz nueva = event.getObject();
		nueva.setAplicacion(aplicacion);
		aplicacion.addProvee(nueva);
	}
	
	public void onAddConsume(SelectEvent<Interfaz> event) {
		Interfaz nueva = event.getObject();
		nueva.setAplicacion(aplicacion);
		aplicacion.addConsume(nueva);
	}
	
	public void onEditConsume(SelectEvent<Interfaz> event) {
		
	}
	
	public void onEditProvee(SelectEvent<Interfaz> event) {
		/*Interfaz edit = event.getObject();
		aplicacion.removeProvee(edit);
		aplicacion.addProvee(edit);*/
	}
}
