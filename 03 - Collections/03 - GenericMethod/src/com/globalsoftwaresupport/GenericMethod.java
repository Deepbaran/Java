package com.globalsoftwaresupport;

public class GenericMethod {

	public <T,V> void printItems(T t, V v) {
		System.out.println(t.toString());
		System.out.println(v.toString());
	}
	
	// <T> defines that the method is a Generic method.
	// The method does not return anything and takes a array items of type T (Generic) as parameter.
	public <T> void showItems(T[] items) {
		for(T item : items)
			System.out.println(item);
	}
	
	// The method returns a value of type T (Generic) and takes a array items of type T (Generic) as parameter.
	public <T> T showItem(T item) {
		System.out.println("The item is: " + item.toString());
		return item;
	}
}
