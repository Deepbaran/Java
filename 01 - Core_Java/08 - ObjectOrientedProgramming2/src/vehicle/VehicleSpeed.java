package vehicle;

public class VehicleSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v = new Vehicle(50); // Vehicle constructor is called
		v.print();
		v.color = "Black";
		v.setMaxSpeed(10);
		v.print();
		
		Car c = new Car(10, 100); // Car(sub class) constructor is called after the Vehicle(Super class) Constructor
		// Car inherits Vehicle class
		// So, Car has Vehicle's constructor too
		// Which is called the moment Car object is created ans it's constructor is called
		// When we create a derived class's constructor, the parent class object is also called
		
//		c.numGears = 10;
		c.color = "Black"; // Inherited
		c.print(); 
		c.setMaxSpeed(100);
		c.print(); // calling it's own print() and not the super class's
		// If Car did not have it's own print() function, then it would has used Vehicle's print() function
		// But as Car has it's own print() function, so it will OVERRIDE Vehicle's print() function
		// each object calls it's own functions if available. Otherwise they search their super class for the function
				
		// If super class and subclass has same functions then to call the super class's function from sub class use the following
		
		/*****************************************************************************************************************************/
		
//		Vehicle v1; // This line means that we are promising to the compiler that v will point to a memory that is Vehicle object
		
		// But v1 can also point to a Car or a Truck
		// Because every Car is a Vehicle and every Truck is a Vehicle
		// Car and Truck both inherited all the data members of Vehicle.
		
		// So, every super class can point to any sub class
		
		Vehicle v1 = new Car(10, 20);// v1 is a vehicle type object that is pointing towards Car object
		// v1 only has access to Vehicle's members that Car inherited
		
//		v1.isConvertible(); // We cannot call this function
		// v1 is a Vehicle object that is pointing towards Car
		// So, we can only call those functions that present in Vehicle
		
		v1.print();
		// We can call print() because Vehicle and every other class that is inheriting from Vehicle has print()
		// Even if print() is not explicitly defined in the subclass, compiler knows there is a print() function in the super class
		// So, there will be no issue is executing this code
		// If print() is present in the sub class then sub class's print() will be called and super class's print() will be overridden
		// Otherwise super class's print() function will be called
		
		// Overridining is polymorphism (IMO)
		
		
	}

}
