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
		String token = null;
		
		if (requestHeaders.getRequestHeader("Authorization") != null) {
			token = requestHeaders.getRequestHeader("Authorization").get(0);
		} else  if (requestHeaders.getRequestHeader("Cookie") != null) {
			token = requestHeaders.getRequestHeader("Cookie").get(0);
		}
		
		
		if (securityContext.getUserPrincipal() != null) {
			userName = securityContext.getUserPrincipal().getName();
			response = Response.ok(userName).build();
		} else {
			response = Response.status(Status.UNAUTHORIZED).build();
		}
		
		return response;
	}
	
	
}
