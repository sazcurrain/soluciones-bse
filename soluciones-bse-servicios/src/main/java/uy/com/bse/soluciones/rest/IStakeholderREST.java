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

import uy.com.bse.soluciones.dto.StakeholderDTO;

@Path("stakeholders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IStakeholderREST {
	
	@GET
	Response getAll();

	@GET
	@Path("{id}")
	Response getStakeholderById(@PathParam("id") Long id);

	@PUT
    @Path("{id}")
	Response update(@PathParam("id") Long id, StakeholderDTO stakeholder);
	
	@DELETE
	@Path("{id}")
	Response delete(@PathParam("id") Long id);
	
	@POST
	Response create(StakeholderDTO stakeholder);

}
