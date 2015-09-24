package com.myrest.login.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import com.myrest.student.rest.resource.AbstractResource;

import co.za.metropolitan.login.dto.LoginResponseDTO;

@Path(value="/login")
public class AuthenticationResource extends AbstractResource{
	
	@Context
	private SecurityContext securityContext;
	
	 @Context
	 HttpHeaders requestHeaders;

	@POST @Path("/loginUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUser() {
		String userName = null;
		Response response = null;
		
		if (securityContext.getUserPrincipal() != null) {
			userName = securityContext.getUserPrincipal().getName();
			LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
			loginResponseDTO.setUserName(userName);
			loginResponseDTO.setStatus(Status.OK.name());
			response = Response.ok(loginResponseDTO).build();
		} else {
			LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
			loginResponseDTO.setStatus(Status.UNAUTHORIZED.name());
			response = Response.ok(loginResponseDTO).build();
			response = Response.status(Status.UNAUTHORIZED).build();
		}
		
		return response;
	}
	
	
}
