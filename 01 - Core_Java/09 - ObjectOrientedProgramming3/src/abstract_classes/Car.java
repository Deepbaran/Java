package abstract_classes;

// vehicle class is final class. So, we cannot extend vehicle class [Commented out the final part]
public abstract class Car extends Vehicle { // Car extending Vehicle. Class car is inheriting the properties of class Vehicle
//	String color;
//	int maxSpeed;
	
	int numGears;
	boolean isConvertible;
	
	public Car() {
		super(100);
	}
	
	public Car(int numGears, int maxSpeed) {
		// calls the default constructor of the parent class implicitly
		super(maxSpeed); // To call our own constructor in the parent class
		
		this.numGears = numGears;
		System.out.println("Car Constructor");
	}
	
	public boolean isConvertible() {
		return isConvertible;
	}
	
	// We cannot override the print() function. Because print() function is a final method [Commented out the final part]
	public void print() {
//		System.out.println("Car Color: " + color); // color is inherited from Vehicle class
//		System.out.println("Car Speed: " + getMaxSpeed()); // getMaxSpeed() is inherited from Vehicle class
		
		super.print(); // To access data elements of the parent class
		// super is the parent object
		
		System.out.println("Car numGears: " + numGears);
		System.out.println("Car isConvertible: " + isConvertible);
	}
	
	/*
	 * To solve the abstract class, we have two ways,
	 * 1. Either Car itself is abstract class and
	 *    the sub class that extends Car may define isMotorize() abstract class unless that class also is a abstract class
	 * 2. define the abstract class
	 */
	@Override
	public boolean isMotorized() { // one inherited abstract class is defined
		return false;
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
 */
