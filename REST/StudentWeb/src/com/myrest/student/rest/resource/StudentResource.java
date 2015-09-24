package com.myrest.student.rest.resource;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import co.za.metropolitan.student.dto.StudentDTO;
import co.za.metropolitan.student.ejb.StudentBeanLocal;

@Path(value="/services/students")
public class StudentResource extends AbstractResource {

	@Inject
	StudentBeanLocal studentBeanLocal;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createStudent(@Context UriInfo uriInfo,
			StudentDTO studentDTO) {
		long studentID = studentBeanLocal.addStudent(studentDTO);
		URI uri = uriInfo.getBaseUriBuilder().path(StudentResource.class)
				.path(String.valueOf(studentID)).build();
		return Response.created(uri).build();

	}

	@GET
	@Path( "/{id}" )
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@PathParam( "id" ) String id) {
		StudentDTO studentDTO = studentBeanLocal.getStudent(id);
		return Response.ok(studentDTO).build();
	}
		
}
