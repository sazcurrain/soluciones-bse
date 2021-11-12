package uy.com.bse.soluciones.backingbeans;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.Persona;
import uy.com.bse.soluciones.domain.Profesion;
import uy.com.bse.soluciones.domain.Enumeradores.Sexo;
import uy.com.bse.soluciones.ejbs.InterfazService;
import uy.com.bse.soluciones.ejbs.PersonaService;
import uy.com.bse.soluciones.ejbs.ProfesionService;

/**
 * Backing Bean de las pantallas de Interfaz
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("interfazController")
@ViewScoped
public class InterfazController implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Interfaz interfaz = new Interfaz();

	
	@EJB
	InterfazService interfazService;
	
	
	public InterfazController() {
		
	}

	public Interfaz getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(Interfaz interfaz) {
		this.interfaz = interfaz;
	}
	
	/**
	 * Retorno la lista de personas cargadas en la BD
	 * @return List<Persona>
	 */
	public List<Interfaz> getListaInterfaces(){
		return interfazService.getInterfaces();
		
	}
	
	/**
	 * Busca a una interfaz por el ID
	 * Si la interfaz existe en la BD retorna esa interfaz
	 * En caso contrario crea una nueva
	 */
	public void findInterfazById() {
		if (interfaz.getId() != null) {
			interfaz = interfazService.find(interfaz.getId());
			if (interfaz == null) {
				interfaz = new Interfaz();
			}
		}
	}
	
	public boolean isManaged(Long id) {
		return id != null;
	}
}
