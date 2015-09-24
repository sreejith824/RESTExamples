package com.myrest.student.rest.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.myrest.student.rest.resource.AbstractResource;

@Interceptor
@SecurityValidator
public class SecurityInterceptor {
	
	@AroundInvoke
	public Object validateUser(InvocationContext invocationContext) throws Exception {
		AbstractResource resource = (AbstractResource) invocationContext.getTarget();
		if (!resource.getUserValidity().equalsIgnoreCase("Success")) {
			throw new Exception("Invalid Login");
		};
		return invocationContext.proceed();
	}
}
