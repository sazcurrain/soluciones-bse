package uy.com.bse.soluciones.rest;


import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import uy.com.bse.soluciones.domain.Aplicacion;
import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.dto.AplicacionDTO;
import uy.com.bse.soluciones.dto.InterfazDTO;
import uy.com.bse.soluciones.dto.StakeholderDTO;
import uy.com.bse.soluciones.dto.StakeholdersDTO;
import uy.com.bse.soluciones.ejbs.AplicacionService;
import uy.com.bse.soluciones.ejbs.StakeholderService;


@Stateless
@LocalBean
public class AplicacionREST implements IAplicacionREST {

	@EJB
	AplicacionService aplicacionService;
	
	@Context
	UriInfo uriInfo;
	
	/**
	 * La respuesta de todo GET deberia ser 200 OK si se ejecuto correctamente
	 */
	@Override
	@Transactional
	public Response getById(Long id) {
		Aplicacion aux = buscarAplicacion(id);
		return Response.ok(AplicacionDTO.adaptEntity(aux)).build();
	}
	
	/**
	 * Metodo auxiliar que se encarga de buscar una factura
	 * Si la encuentra la retorna, en caso contrario lanza una NotFoundException
	 * @param id Identificador de la factura
	 * @return Factura
	 */
	private Aplicacion buscarAplicacion(Long id) {
		Aplicacion aux = aplicacionService.find(id);
		
		if (aux != null) {
			return aux;
		}
		else {
			throw new NotFoundException();	
		}
	}
}
