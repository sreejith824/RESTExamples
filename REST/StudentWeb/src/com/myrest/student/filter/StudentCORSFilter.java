package com.myrest.student.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentCORSFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Inside Filter");
		
		((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "http://localhost:9000");
		((HttpServletResponse) response).addHeader("Access-Control-Allow-Credentials", "true");
		((HttpServletResponse) response).addHeader("Access-Control-Allow-Method", "GET, POST, PUT, DELETE, OPTIONS");
		((HttpServletResponse) response).addHeader("Content-Type", "application/json");
		((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "Content-Type");

		String accessControlReqHeader = ((HttpServletRequest) request).getHeader("Access-Control-Request-Headers");
		System.out.println(accessControlReqHeader);
		
		if (((HttpServletRequest) request).getMethod().equalsIgnoreCase("OPTIONS")) {
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", accessControlReqHeader);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
