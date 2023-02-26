package com.globalsoftwaresupport;

class Person implements Comparable<Person> {

	private int age;
	private String name;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public int compareTo(Person otherPerson) {
		return Integer.compare(age, otherPerson.getAge());
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}

public class App {
	
	// T is restricted to type Comparable<T>
	// T is a bounded type parameter
	public static <T extends Comparable<T>> T calculateMin(T num1, T num2) {
		
		if(num1.compareTo(num2) < 0)
			return num1;
		
		return num2;
	}
	
	// T is restricted to type Number
	public static <T extends Number> double add(T num1, T num2) {
		double result = num1.doubleValue() + num2.doubleValue();
		return result;
	}

	public static void main(String[] args) {
		
		String s1 = "Deep";
		String s2 = "Kar";
		System.out.println(calculateMin(s1, s2)); // T will be automatically converted to String
		
		// As the Person class implements the Comparable interface with raw type Person and also overrides the compareTo method, so we can use the objects of the Person class here.
		// The Person object casts to Comparable object of raw type Person and then the overridden compareTo method is used.
		System.out.println(calculateMin(new Person("Deepbaran", 23), new Person("Kar", 24))); // The overridden toString() method is implemented here.
		
		System.out.println(add(10,5.4f)); // 15.400000095367432
		
	}

}
