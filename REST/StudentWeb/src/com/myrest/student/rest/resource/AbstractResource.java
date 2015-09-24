package com.myrest.student.rest.resource;

import javax.inject.Inject;

import com.myrest.student.rest.interceptor.SecurityValidator;
import com.myrest.student.rest.producer.LoginQualifier;

@SecurityValidator
public abstract class AbstractResource {

	@Inject
	@LoginQualifier
	String userValidity;
	
	public String getUserValidity() {
		return userValidity;
	}
}
