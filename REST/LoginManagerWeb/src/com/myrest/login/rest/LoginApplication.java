package com.myrest.login.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * Servlet implementation class StudentApplication
 */

public class LoginApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(com.myrest.login.rest.resource.AuthenticationResource.class);
		return classes;
	}

}
