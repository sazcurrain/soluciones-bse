package uy.com.bse.soluciones.back.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import uy.com.bse.soluciones.domain.Cluster;
import uy.com.bse.soluciones.domain.Enumeradores.Entorno;
import uy.com.bse.soluciones.ejbs.ClusterService;

/**
 * Backing Bean de las pantallas de Cluster
 * 
 * @author aem
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("clusterController")
@ViewScoped
public class ClusterController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cluster cluster = new Cluster();

	@EJB
	ClusterService clusterService;

	public ClusterController() {

	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	/**
	 * Retorno la lista de Clusters cargadas en la BD
	 * 
	 * @return List<Cluster>
	 */
	public List<Cluster> getListaClusters() {
		return clusterService.getClusters();

	}

	/**
	 * Agrega una nueva Cluster ala BD
	 * 
	 * @return String con la regla de navegacion
	 */
	public String crearCluster() {
		clusterService.update(cluster);
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
	 * Busca a una Cluster por el ID Si la Cluster existe en la BD retorna esa Cluster
	 * En caso contrario crea una nueva
	 */
	public void findClusterById() {
		if (cluster.getId() != null) {
			cluster = clusterService.find(cluster.getId());
			if (cluster == null) {
				cluster = new Cluster();
			}
		}
	}

	/**
	 * Elimina una Cluster de la BD
	 * 
	 * @param p
	 */
	public void eliminar(Cluster p) {
		clusterService.delete(p);
	}

	public boolean isManaged(Long id) {
		return id != null;
	}
}
