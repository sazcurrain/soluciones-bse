package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.SolInfra;
import uy.com.bse.soluciones.ejbs.SolInfraService;

/**
 * Backing Bean de las pantallas de Servidor
 * 
 * @author aem
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("solInfraController")
@ViewScoped
public class SolInfraController implements Serializable {

	private static final long serialVersionUID = 1L;

	private SolInfra solInfra = null;
	
	private List<SolInfra> filteredSolInfra;
	

	@EJB
	SolInfraService solInfraService;

	public SolInfraController() {

	}

	public SolInfra getSolInfra() {
		return solInfra;
	}

	public void setSolInfra(SolInfra solInfra) {
		this.solInfra = solInfra;
	}

	/**
	 * Retorno la lista de SolInfra cargadas en la BD
	 * 
	 * @return List<Servidor>
	 */
	public List<SolInfra> getListaSolInfra() {
		return solInfraService.getSolsInfra(SolInfra.class);

	}
	
	public List<String> getTipos(){
		return solInfraService.getTipos();
	}
	
	public String getFormUrl(SolInfra solInfra) {
		return "alta"+solInfra.getTipo()+".xhtml?id="+solInfra.getId();
	}
	
	public String getViewUrl(SolInfra solInfra) {
		return "view"+solInfra.getTipo()+".xhtml?id="+solInfra.getId();
	}
	
	/**
	 * Elimina una SolInfra de la BD
	 * 
	 * @param p
	 */
	public void eliminar(SolInfra si) {
		solInfraService.delete(si);
	}

	public List<SolInfra> getFilteredSolInfra() {
		return filteredSolInfra;
	}

	public void setFilteredSolInfra(List<SolInfra> filteredSolInfra) {
		this.filteredSolInfra = filteredSolInfra;
	}
}
