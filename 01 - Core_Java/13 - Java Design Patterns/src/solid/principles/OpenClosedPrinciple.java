package solid.principles;

public class OpenClosedPrinciple {

	/*
	 * Software entities (e.g., classes, modules, functions) should be open for an extension, but closed for modification.
	 */
	
	public static class VehicleCalculations {
	    public double calculateValue(Vehicle v) {
	        if (v instanceof Car) {
	            return v.getValue() * 0.8;
	        }
	        if (v instanceof Bike) {
	            return v.getValue() * 0.5;
	        }
			return 0.0;
	    }
	}
	        
	/*
	 * Suppose we now want to add another subclass called Truck. We would have to modify the above class by adding another if statement, which goes against the Open-Closed Principle.
	 * A better approach would be for the subclasses Car and Truck to override the calculateValue method:        
	 */
	
    public static class Vehicle {
        public double calculateValue() { return 0.0; }
		public double getValue() {
			return 0.0;
		}
    }
    public static class Car extends Vehicle {
        public double calculateValue() {
            return this.getValue() * 0.8;
        }
    }
    public static class Truck extends Vehicle{
        public double calculateValue() {
            return this.getValue() * 0.9;
        }
    }
    public static class Bike extends Vehicle{
        public double calculateValue() {
            return this.getValue() * 0.9;
        }
    }
        
    /*
     * Adding another Vehicle type is as simple as making another subclass and extending from the Vehicle class.
     */
	        
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
