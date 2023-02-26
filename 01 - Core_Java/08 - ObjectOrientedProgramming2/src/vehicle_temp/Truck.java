package vehicle_temp;

import vehicle.Vehicle;

public class Truck extends Vehicle{
	int maxLoadingCapacity;
	
	public Truck() {
		super(30);
	}
	
	public void print() {
		System.out.println("Truck" + maxLoadingCapacity);
		System.out.println("Truck color: " + color); // we cannot access 
		System.out.println("Truck speed: " + getMaxSpeed());
	}

}

/*
 * We cannot access friendly or default data members of Vehicle in Truck, even though all the data members of Vehicle are present in Car
 * To access a friendly data member, we need to declare it as "protected"
 * 
 * protected -> protected data members are friendly(default, i.e. accessible inside the package) and also accessible by subclasses
 * outside the package too
 * 
 * 
 */
