package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.Servidor;
import uy.com.bse.soluciones.domain.Entorno;
import uy.com.bse.soluciones.ejbs.ServidorService;

/**
 * Backing Bean de las pantallas de Servidor
 * 
 * @author aem
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("servidorController")
@ViewScoped
public class ServidorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Servidor servidor = new Servidor();

	@EJB
	ServidorService servidorService;

	public ServidorController() {

	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	/**
	 * Retorno la lista de Servidors cargadas en la BD
	 * 
	 * @return List<Servidor>
	 */
	public List<Servidor> getListaServidores() {
		return servidorService.getServidores();

	}

	/**
	 * Agrega una nueva Servidor ala BD
	 * 
	 * @return String con la regla de navegacion
	 */
	public String crearServidor() {
		try {
			servidorService.update(servidor);
			return "servidores.xhtml?faces-redirect=true";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurió un error.", null));
			return "";
		}
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
	 * Busca a una Servidor por el ID Si la Servidor existe en la BD retorna esa Servidor
	 * En caso contrario crea una nueva
	 */
	public void findServidorById() {
		if (servidor.getId() != null) {
			servidor = servidorService.find(servidor.getId());
			if (servidor == null) {
				servidor = new Servidor();
			}
		}
	}

	/**
	 * Elimina una Servidor de la BD
	 * 
	 * @param p
	 */
	public void eliminar(Servidor p) {
		servidorService.delete(p);
	}

	public boolean isManaged(Long id) {
		return id != null;
	}
}
