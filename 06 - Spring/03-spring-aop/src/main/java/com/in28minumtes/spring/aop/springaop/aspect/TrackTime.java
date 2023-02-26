package com.in28minumtes.spring.aop.springaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //Intercept only methods
@Retention(RetentionPolicy.RUNTIME) //Intercept at Run time
//Methods
//Runtime
public @interface TrackTime {
	// Custom Annotation
}
