package uy.com.bse.soluciones.rest;


import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.dto.StakeholderDTO;
import uy.com.bse.soluciones.dto.StakeholdersDTO;
import uy.com.bse.soluciones.ejbs.StakeholderService;


@Stateless
@LocalBean
public class StakeholderREST implements IStakeholderREST {

	@EJB
	StakeholderService stakeholderService;
	
	@Context
	UriInfo uriInfo;

	/**
	 * La respuesta de todo GET deberia ser 200 OK si se ejecuto correctamente
	 */
	@Override
	public Response getAll(){
		List<Stakeholder> stakeholders = stakeholderService.getStakeholders();
		return Response.ok(new StakeholdersDTO(StakeholderDTO.adaptEntityList(stakeholders))).build();
	}
	
	/**
	 * La respuesta de todo GET deberia ser 200 OK si se ejecuto correctamente
	 */
	@Override
	public Response getStakeholderById(Long id) {
		Stakeholder aux = buscarStakeholder(id);
		return Response.ok(StakeholderDTO.adaptEntity(aux)).build();
	}
	
	/**
	 * La respuesta del DELETE puede ser:
	 * 200 OK o 204 NO Content si el request se ejecuto correctamente
	 */
	@Override
    public Response update(Long id, StakeholderDTO dto) {
		Stakeholder aux = dto.createEntity(); 		

		stakeholderService.update(aux);
		
		return Response.ok().build();
	}

	/**
	 * La respuesta del DELETE puede ser:
	 * 200 OK -> si en el response body se quiere incluir algo
	 * 204 NO Content -> si el response no incluye nada en el body 
	 */
	@Override
	public Response delete(Long id) {
		Stakeholder aux = buscarStakeholder(id);
		stakeholderService.delete(aux);
		return Response.noContent().build();
	}

	/**
	 * La respuesta del create puede ser:
	 * 201 Created y la URI del nuevo recurso creado
	 * 204 NO Content si el recurso creado no se puede identificar con una URI 
	 */
	@Override
	public Response create(StakeholderDTO dto) {
		
		//Si no se recibe factura se lanza exception con un 400 - Bad Request
		if (dto == null) {
			throw new BadRequestException();
		}
				
		Stakeholder entity = stakeholderService.update(dto.createEntity());
		URI facturaUri = uriInfo.getAbsolutePathBuilder().path(entity.getId().toString()).build();
		return Response.created(facturaUri).build();
	}
	
	
	/**
	 * Metodo auxiliar que se encarga de buscar una factura
	 * Si la encuentra la retorna, en caso contrario lanza una NotFoundException
	 * @param id Identificador de la factura
	 * @return Factura
	 */
	private Stakeholder buscarStakeholder(Long id) {
		Stakeholder aux = stakeholderService.find(id);
		
		if (aux != null) {
			return aux;
		}
		else {
			throw new NotFoundException();	
		}
	}
}
