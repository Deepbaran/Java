package solid.principles;

public class DependencyInversionPrinciple {

	/*
	 * The Dependency Inversion Principle (DIP) states that we should depend on abstractions (interfaces and abstract classes) instead of concrete implementations (classes). 
	 * The abstractions should not depend on details; instead, the details should depend on abstractions.
	 * Consider the example below. We have a Car class that depends on the concrete Engine class; therefore, it is not obeying DIP.
	 */
	
	public class Car {
	    private Engine engine;
	    public Car(Engine e) {
	        engine = e;
	    }
	    public void start() {
	        engine.start();
	    }
	}
	public class Engine {
	   public void start() {}
	}
	
	/*
	 * The code will work, for now, but what if we wanted to add another engine type, let’s say a diesel engine? This will require refactoring the Car class.
	 * However, we can solve this by introducing a layer of abstraction. Instead of Car depending directly on Engine, let’s add an interface:
	 */
	
	public interface Engine2 {
	    public void start();
	}
	
	/* 
	 * Now we can connect any type of Engine that implements the Engine interface to the Car class:
	 */
	
	public class Car2 {
	    private Engine2 engine;
	    public Car2(Engine2 e) {
	        engine = e;
	    }
	    public void start() {
	        engine.start();
	    }
	}
	public class PetrolEngine implements Engine2 {
	   public void start() {}
	}
	public class DieselEngine implements Engine2 {
	   public void start() {}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
