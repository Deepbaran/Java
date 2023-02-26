package generics;

import final_keyword.Vehicle;

public class Print {
	
	// Generic Methods
	private static <T> void printArray(T a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	// Bound Generic Type
	private static <T extends PrintInterface> void printArray(T a[]) { 
		// This method will only take the classes that are implementing the PrintInterface or subclasses of these classes
		// We could also use a class instead of an interface. Then only that class and it's subclasses could use this method
		// using class would restrict our generic method to a class and it's subclasses
		// so, always extend interface for bound generic method
		// For generic bound, extends keyword is used regardless if we are using class or interface
		for(int i = 0; i < a.length; i++) {
			a[i].print();
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[] = new Integer[10]; // all elements are null by default
		printArray(a);
		
		Vehicle v[] = new Vehicle[10]; 
		for(int i = 0; i < 10; i++) {
			v[i] = new Vehicle(10);
		}
		printArray(v); // address of the Vehicle object is printed
	}

}

// for int(primitive) 0 is dynamically allocated by default
// for Integer(class) null is dynamically allocated by default

/*
 * We can bound the generic method and define which type of T it will take 
 */
