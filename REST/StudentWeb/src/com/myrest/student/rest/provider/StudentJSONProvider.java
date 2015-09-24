package com.myrest.student.rest.provider;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

public class StudentJSONProvider implements MessageBodyWriter<Object>{

	@Override
	public long getSize(Object arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void writeTo(Object arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream arg6)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
