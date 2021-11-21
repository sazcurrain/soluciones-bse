package uy.com.bse.soluciones.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import uy.com.bse.soluciones.domain.ComponenteSoftware;
import uy.com.bse.soluciones.domain.Stakeholder;
import uy.com.bse.soluciones.domain.Enumeradores.Rol;
import uy.com.bse.soluciones.dto.ComponentesSoftwareDTO;
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

	@Override
	public Response getAll() {
		List<Stakeholder> stakeholders = stakeholderService.getStakeholders();
		List<StakeholderDTO> dtos = new ArrayList<StakeholderDTO>();

		for (Stakeholder stakeholder : stakeholders) {
			dtos.add(new StakeholderDTO(stakeholder));
		}
		return Response.ok(new StakeholdersDTO(dtos)).build();
	}

	@Override
	public Response getStakeholderById(Long id) {
		Stakeholder aux = buscarStakeholder(id);
		return Response.ok(new StakeholderDTO(aux)).build();
	}

	/*
	 * Pongo que se ejecute sin transacción, porque si no se propaga al update del
	 * service y las excepciones de atributos unique duplicados no saltan hasta
	 * despues que finaliza la transacción. La operación sigue siendo segura porque
	 * el update tiene su propia transacción.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public Response update(Long id, StakeholderDTO dto) {
		Stakeholder aux = dto.createEntity();

		try {
			stakeholderService.update(aux);
			return Response.ok().build();
		} catch (EJBTransactionRolledbackException e) {
			String message = "";
			for (Throwable t = e.getCausedByException(); t != null; t = t.getCause()) {
				if (PersistenceException.class.isInstance(t)) {
					message = "Ya existe un usuario con ese documento";
				} else if (ConstraintViolationException.class.isInstance(t)) {
					for (ConstraintViolation cv : ((ConstraintViolationException) t).getConstraintViolations()) {
						message += cv.getPropertyPath() + ": " + cv.getMessage() + "\n";
					}
				}
			}
			return Response.status(Response.Status.BAD_REQUEST).entity(message).type(MediaType.TEXT_PLAIN).build();
		}
	}

	@Override
	public Response delete(Long id) {
		Stakeholder aux = buscarStakeholder(id);
		stakeholderService.delete(aux);
		return Response.noContent().build();
	}
	

	/*
	 * Pongo que se ejecute sin transacción, porque si no se propaga al update del
	 * service y las excepciones de atributos unique duplicados no saltan hasta
	 * despues que finaliza la transacción. La operación sigue siendo segura porque
	 * el update tiene su propia transacción.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public Response create(StakeholderDTO dto) {

		if (dto == null) {
			throw new BadRequestException();
		}
		
		try {
			Stakeholder entity = stakeholderService.update(dto.createEntity());
			URI facturaUri = uriInfo.getAbsolutePathBuilder().path(entity.getId().toString()).build();
			return Response.created(facturaUri).build();
		} catch (EJBTransactionRolledbackException e) {
			String message = "";
			for (Throwable t = e.getCausedByException(); t != null; t = t.getCause()) {
				if (PersistenceException.class.isInstance(t)) {
					message = "Ya existe un usuario con ese documento";
				} else if (ConstraintViolationException.class.isInstance(t)) {
					for (ConstraintViolation cv : ((ConstraintViolationException) t).getConstraintViolations()) {
						message += cv.getPropertyPath() + ": " + cv.getMessage() + "\n";
					}
				}
			}
			return Response.status(Response.Status.BAD_REQUEST).entity(message).type(MediaType.TEXT_PLAIN).build();
		}
	}

	private Stakeholder buscarStakeholder(Long id) {
		Stakeholder aux = stakeholderService.find(id);

		if (aux != null) {
			return aux;
		} else {
			throw new NotFoundException();
		}
	}

	@Override
	public Response getDesarrollosByDocumento(String documento) {
		if (stakeholderService.checkByDocumento(documento)) {
			List<ComponenteSoftware> componentes = stakeholderService.getStakeholderComponentesByRol(documento,
					Rol.DESARROLLADOR);
			return Response.ok(new ComponentesSoftwareDTO(componentes)).build();
		} else {
			throw new NotFoundException();
		}
	}
}
