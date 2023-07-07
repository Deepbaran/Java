package interfaces;

public interface CarInterface extends VehicleInterface{
	// data member of interfaces
	public final static double PI = 3.14;
	
	public String getCompany();
	// As none of the functions in VehicleInterface is implemented here, so we need to implement them at the sub-class
}

// An interface can extend another interface
// To store data members, the data members must be public final static
// Only for storing constants we will use data members in interfaces, otherwise we will not use data members

/*
Marker Interface: A marker interface is an interface that has no methods or constants inside it. It provides run-time type information about objects, so the compiler and JVM have additional information about the object. 
A marker interface is also called a tagging interface.
*/

// Functions inside interfaces are abstract functions. We can use the abstract keyword infront of them if we wish to, but not needed.