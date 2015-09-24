package com.myrest.student.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


/**
 * Servlet implementation class StudentApplication
 */

public class StudentApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(com.myrest.student.rest.resource.StudentResource.class);
		classes.add(com.myrest.student.rest.provider.StudentJSONProvider.class);
		classes.add(com.myrest.login.rest.resource.AuthenticationResource.class);
		
		return classes;
	}

}
