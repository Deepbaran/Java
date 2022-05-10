package com.globalsoftwaresupport;

// T is the Generic Type
// Under the hood, whenever we use Generic, Java is going to use the Object Super type and then we typecast it according to the raw type passed in the diamond operator.
class Store<T> {
	
	private T item; // private Object item; <-- Under the hood
	
	public void setItem(T item) {
		this.item = item;
	}
	
	public T getItem() {
		return this.item;
	}
}

class Hashtable<K,V> {
	
	private K key;
	private V value;
	
	public Hashtable(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Hashtable [key=" + key + ", value=" + value + "]";
	}
}

public class App {

	public static void main(String[] args) {
		
		// raw type
		// <> diamond operator
		// In case we do not use the diamond operator then Java will not give error, rather it will just warn us
		Store<Integer> store = new Store<>(); // We are casting the Object to Integer under the hood
		store.setItem(45);
		// we can cast Object to any other object
		Integer storeValue = store.getItem();
		System.out.println(storeValue);
		
		Hashtable<String,Integer> hashTable = new Hashtable<>("Hello",23);
		System.out.println(hashTable);
	}
}
