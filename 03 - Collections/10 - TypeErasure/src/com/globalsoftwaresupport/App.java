package com.globalsoftwaresupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {	
	
	/**
	 * In order to implement generics, Java uses type erasure
	 * 		This is how generic Java code is handled!!!
	 * 
	 * 		- replace all type parameters in generic types with their bounds or Object
	 * 			if the type parameters are unbounded
	 * 				So the final bytecode will contain plain java objects/classes
	 * 
	 * 		- uses type casts if necessary
	 * 
	 * 		- Sometimes it generates extra methods: the so called bridge methods 
	 * 			in order to maintain polymorphism with generic types
	 * 
	 * 		In the bytecode the following code is equivalent
	 * 
	 * 			List<Integer> list = new ArrayList<>();
	 * 			list.add(3);
	 * 			Integer num = list.get(0);
	 * 			------------------------------
	 * 			List list = new ArrayList();
	 * 			list.add(3);
	 * 			Integer num = (Integer) list.get(0);
	 */
	
	public static void main(String[] args) {
		
	}
}
