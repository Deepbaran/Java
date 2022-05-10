package com.globalsoftwaresupport;

import java.util.ArrayList;
import java.util.List;

public class App {	
	
	/**
	 * - Compiler's ability to look at each method invocation and corresponding declaration to determine the type argument/arguments (such as T) that makes the invocation applicable.
	 * 
	 * - The interface algorithm determines: the types of the arguments + the type that the result is being assigned or returned if available
	 * 
	 * - The interface algorithm tries to find the most specific type that works with all of the arguments.
	 * 
	 * Generic methods and type inference enables us to invoke a generic method as you would an ordinary method, without specifying a type between angle brackets.
	 */
	
	public static <T> void addStore(T t, List<Bucket<T>> list) {
		Bucket<T> bucket = new Bucket<>();
		bucket.setItem(t);;
		list.add(bucket);
		System.out.println(t.toString() + " has been added to the list...");
	}
	
	public static void main(String[] args) {
		 List<Bucket<String>> list = new ArrayList<>();
		 
		 // With Type Inference. Infering the type of T (Generic parameter) according to the type of the argument(s) passed
		 App.addStore("Adam", list);
		 
		 // type weakness: specifying the specified type of the generic
		 App.<String>addStore("Daniel", list);
	}

}

class Bucket<T> {
	private T item;
	
	public T getItem() {
		return this.item;
	}
	
	public void setItem(T item) {
		this.item = item;					
	}
}
