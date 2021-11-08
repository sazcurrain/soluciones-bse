package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.Cluster;
import uy.com.bse.soluciones.domain.Nube;
import uy.com.bse.soluciones.domain.Servidor;
import uy.com.bse.soluciones.domain.SolInfra;
import uy.com.bse.soluciones.domain.Tienda;
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
	
	public String getTipo(SolInfra solInfra) {
		String tipo = "";
		if(Servidor.class.isInstance(solInfra)) {
			tipo = "Servidor";
		} else if (Cluster.class.isInstance(solInfra)) {
			tipo = "Cluster";
		} else if (Nube.class.isInstance(solInfra)) {
			tipo = "Nube";
		} else if (Tienda.class.isInstance(solInfra)) {
			tipo = "Tienda";
		}
		
		return tipo;//"alta"+tipo+".xhtml?id="+solInfra.getId();
	}
	
	public String getFormUrl(SolInfra solInfra) {
		return "alta"+this.getTipo(solInfra)+".xhtml?id="+solInfra.getId();
	}
	
	public String getViewUrl(SolInfra solInfra) {
		return "view"+this.getTipo(solInfra)+".xhtml?id="+solInfra.getId();
	}
	
	/**
	 * Elimina una SolInfra de la BD
	 * 
	 * @param p
	 */
	public void eliminar(SolInfra si) {
		solInfraService.delete(si);
	}
}
