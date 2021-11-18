package uy.com.bse.soluciones.backingbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import uy.com.bse.soluciones.domain.Interfaz;
import uy.com.bse.soluciones.domain.StakeholdersComponente;
import uy.com.bse.soluciones.ejbs.InterfazService;

/**
 * Backing Bean de las pantallas de Interfaz
 * 
 * @author juan
 *
 */
//TODO: Falta incorporar el manejo de excepciones y mostrarlas correctamente en JSF
@Named("navigationController")
@SessionScoped
public class NavigationController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LinkedList<String> breadcrumb = new LinkedList<String>();

	public NavigationController() {
		
	}
	
	public void addToBreadcrumb(String view) {
		this.breadcrumb.push(view);
	}
	
	public String navigateBack() {
		return this.breadcrumb.pop();
	}
	
	
}
