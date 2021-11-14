package uy.com.bse.soluciones.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.dto.StakeholderDTO;

@Path("aplicacion")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public interface IAplicacionREST {
	
	@GET
	@Path("{id}")
	Response getById(@PathParam("id") Long id);

}
