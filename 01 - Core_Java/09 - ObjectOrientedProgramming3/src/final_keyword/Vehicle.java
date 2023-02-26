package final_keyword;

import generics.PrintInterface;

// final class
public final class Vehicle implements PrintInterface{
	protected String color;
	private int maxSpeed;
		
	public Vehicle(int maxSpeed) {
		this.maxSpeed = maxSpeed;
//		System.out.println("Vehicle Constructor");
	}
		
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	// final method
	public final void print() {
		System.out.println("Vehicle Color: " + color);
		System.out.println("Vehicle Speed: " + maxSpeed);
	}
}


/*
 * private and protected modifiers are not allowed in front of class 
 */

/*
 * we cannot override a final method
 * we can not extend a final class
*/













