package com.globalsoftwaresupport;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Creating Annotations
@Retention(RetentionPolicy.RUNTIME) // This annotation is needed to detect our annotation with the help of Reflection
@Target(ElementType.METHOD) // Indicates the contexts in which an annotation type is applicable
@interface MyAnnotation {
	public String name();
}

class Employee {
	
}

public class Person extends Employee {
	
	private String name;
	public int age;
	
	@MyAnnotation(name="MyAnnotation")
	public String returnName() {
		return this.name+" is the name!";
	}
}
