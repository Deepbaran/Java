package solid.principles;

public class SingleResponsibilityPrinciple {

	/*
	 * Every class in Java should have a single job to do. To be precise, there should only be one reason to change a class.
	 */
	
	public class Vehicle {
	    public void printDetails() {}
	    public double calculateValue() { return 0.0; }
	    public void addVehicleToDB() {}
	}
	
	/*
	 * The Vehicle class has three separate responsibilities: reporting, calculation, and database. 
	 * By applying SRP, we can separate the above class into three classes with separate responsibilities.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
