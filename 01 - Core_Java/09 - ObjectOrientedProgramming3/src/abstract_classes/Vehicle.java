package abstract_classes;

// final class
//public final class Vehicle {

// abstract class
public abstract class Vehicle {
	protected String color;
	private int maxSpeed;
		
	public Vehicle(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		System.out.println("Vehicle Constructor");
	}
	 // abstract function
	public abstract boolean isMotorized();
	
	public abstract String getCompany();
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	// final method
//	public final void print() {
	public void print() {
		System.out.println("Vehicle Color: " + color);
		System.out.println("Vehicle Speed: " + maxSpeed);
	}
}


/*
 * private and protected modifiers are not allowed infront of class 
 */

/*
 * we cannot override a final method
 * we can not extend a final class
 * final class prevents inheritance
*/

/*
 * Classes that hold abstract functions must be a abstract class
 * 
 * abstract functions must be defined in the sub classes that extend the abstract class
 * 
 * abstract function is a incomplete function
 * 
 * We cannot create objects of abstract classes
*/












