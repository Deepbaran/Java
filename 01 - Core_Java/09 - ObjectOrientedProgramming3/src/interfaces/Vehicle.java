package interfaces;

public class Vehicle implements VehicleInterface{

	/*
	 * When implementing an interface in out class, we have two options:
	 * 1. Declare our class as abstract and define some or all the functions of the interface in the subclass that'll extend the current class
	 * 2. Define all the functions in the interface  
	 */
	
	public int getMaxSpeed() {
		return 0;
	}
	
	public void print() {
		
	}
	
}


/*
 * We use implements keyword to inherit the interface
 */