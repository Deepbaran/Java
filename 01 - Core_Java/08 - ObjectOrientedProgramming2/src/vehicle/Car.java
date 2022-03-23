package vehicle;

public class Car extends Vehicle { // Car extending Vehicle. Class car is inheriting the properties of class Vehicle
//	String color;
//	int maxSpeed;
	
	int numGears;
	boolean isConvertible;
	
	public Car(int numGears, int maxSpeed) {
		// calls the default constructor of the parent class implicitly
		super(maxSpeed); // To call our own constructor in the parent class
		
		this.numGears = numGears;
		System.out.println("Car Constructor");
	}
	
	public boolean isConvertible() {
		return isConvertible;
	}
	
	public void print() {
//		System.out.println("Car Color: " + color); // color is inherited from Vehicle class
//		System.out.println("Car Speed: " + getMaxSpeed()); // getMaxSpeed() is inherited from Vehicle class
		
		super.print(); // To access data elements of the parent class
		// super is the parent object
		
		System.out.println("Car numGears: " + numGears);
		System.out.println("Car isConvertible: " + isConvertible);
	}

}

/*
 * Parent/Base/Super class -> inherited class
 * 
 * Child/Derived/Sub class -> inheriting class
 * 
 * Car does inherit all the data members of it's super class but we cannot access the private data members of the super class from the sub class
 * We know that Car inherited maxSpeed from Vehicle even though we cannot directly access it through Car object is because we can set the value 
 * and get the value of maxSpeed using getters and setters.
 * O, maxSpeed has to be inherited for it to be set and get. But Car can not directly access it.
 *
 * super -> super is Super class object
 * 
 * Just like "this" refers to the current object, "super" refers to the current super class
 *
 * So, even if there is a data member sub class which has the same name as a data member in the super class, we can access the data member in the
 * super class using "super". Otherwise the sub class data member would be called.
 * 
 * Object() class is the super class of all classes in Java
 *
 */

// private and protected modifiers are not allowed in front of class that is not a nested or inner class.
