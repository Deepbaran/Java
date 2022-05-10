package com.globalsoftwaresupport;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldVariableExample {	
	
	public static void main(String[] args) {
	
		Class<Person> personClass = Person.class;
		
		System.out.println(personClass.getPackageName());
		
		// Get the name of the Superclass
		System.out.println(personClass.getSuperclass().getName());
		
		Field[] fields = personClass.getDeclaredFields(); // Getting Fields using Reflection
		
		Method[] methods = personClass.getMethods(); // Getting Methods using Reflection
		
		Method[] privateMethods = personClass.getDeclaredMethods(); // Getting Private Methods using Reflection
		
		Class[] interfaces = personClass.getInterfaces(); // Getting implemented interfaces using Reflection
		
		for(Field f : fields) {
			f.setAccessible(true);
			System.out.println(f.getName());
		}
			
		for(Method m : methods) {			
			System.out.println(m.getName()+" return type: "+m.getReturnType());
		}
		
		for(Method m : privateMethods) {
			System.out.println(m.getName()+" return type: "+m.getReturnType());
		}
		
		for(Class c : interfaces) {
			System.out.println(c.getName());
		}
		
		// Check if there is any method annotated with a particular annotation
		for(Method m : methods) {
			if(m.isAnnotationPresent(MyAnnotation.class)) {
				System.out.println(m.getName());
			}
		}
			
	}
}




