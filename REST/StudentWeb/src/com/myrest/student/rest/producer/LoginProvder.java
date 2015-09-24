package com.myrest.student.rest.producer;

import java.util.Collection;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.SecurityContext;

import co.za.metropolitan.student.threadlocal.ApplicationSecurityContext;

@RequestScoped
public class LoginProvder {

	@Context
	private SecurityContext securityContext;
	
	@Context
	HttpServletResponse	 response;
	
	 @Context
	 HttpHeaders requestHeaders;
	
	@Produces
	@LoginQualifier
	public String validateUser(InjectionPoint injectionPoint) {
		String userValidity = "Failure";
		if (securityContext.getUserPrincipal() != null) {
			userValidity = "Success";
		} 
		
		Collection<String> responseHeaders =  response.getHeaderNames();
		System.out.println("----------responseHeaders----------------");
		for (String responseHeader : responseHeaders) {
			
			System.out.println(responseHeader + " : " + ((HttpServletResponse) response).getHeader(responseHeader));
		}
		System.out.println("----------responseHeaders----------------");
		
		System.out.println("----------requestHeaders----------------");
		
		MultivaluedMap<String,String> requestHeadersMap=  requestHeaders.getRequestHeaders();
		Set<String> requestHeadersMapKeySet = requestHeadersMap.keySet();
		for (String requestHeadersMapKey : requestHeadersMapKeySet) {
			requestHeadersMap.get(requestHeadersMapKey).get(0);
			System.out.println(requestHeadersMapKey + " : " + requestHeadersMap.get(requestHeadersMapKey).get(0));
		}
		System.out.println("----------requestHeaders----------------");
		
		String token = null;
		if (requestHeaders.getRequestHeader("Authorization") != null) {
			token = requestHeaders.getRequestHeader("Authorization").get(0);
		} else  if (requestHeaders.getRequestHeader("Cookie") != null) {
			token = requestHeaders.getRequestHeader("Cookie").get(0);
		}
		
		ApplicationSecurityContext.setSecurityToken(token);
		return userValidity;
	}
}
