package uy.com.bse.soluciones.interceptors;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import uy.com.bse.soluciones.backingbeans.NavigationController;

public class RequestInterceptor implements PhaseListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private NavigationController nav;

	@Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // Do your job here which should run before the render response phase.
    }

    @Override
    public void afterPhase(PhaseEvent event) {
    	FacesContext ctx = FacesContext.getCurrentInstance();
    	nav.addToBreadcrumb(ctx.getViewRoot().getViewId());
    }

}
