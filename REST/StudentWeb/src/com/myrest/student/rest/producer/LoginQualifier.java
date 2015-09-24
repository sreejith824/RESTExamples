package com.myrest.student.rest.producer;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Inherited
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
public @interface LoginQualifier {

}
