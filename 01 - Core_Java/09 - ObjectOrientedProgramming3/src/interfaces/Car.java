package interfaces;

public class Car extends Vehicle implements VehicleInterface, CarInterface {
	@Override
	public void print() {
		
	}
	
	@Override
	public int getMaxSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getCompany() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


/*
 * We can extend only one class. We can not extend more than one class. Multiple inheritance is not allowed in Java
 * But we can implement multiple interfaces
 * But the sub-class will need to implement all of their functions regardless if it's super class has implemented them and define their classes 
 */