package generics;

// Generic Class
public class Pair<T> {
	private T first;
	private T second;
	
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}
 }



/*
 * T is a data type that is defined at the time of object creation.
 * It's called a generic class
 * 
 * Every class is a sub-class of Object class i.e, all classes inherit the Object Class.
 * So, if we do not explicitly define the type of T, then it will be of Object type.
 * and we can use in any class as our data type because, all classes inherit Object.
 * 
 * This is a bad practice. So, always explicitly define the data type of T
 * 
 * T can not be of type primitive data type(int, float, double, etc.)
 * T can be of type class
 * So, use Integer, Character, Boolean etc.
 * 
 * int a = 10; // variable created
 * Integer a = 10; // Object Created
 */