package multiThreading;

class Hi extends Thread {
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hi");
			try { 
				Thread.sleep(1000); // Suspend the Thread in milliseconds 
			} catch (Exception e) {}
		}
	}
}

class Hello extends Thread {
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			try { 
				Thread.sleep(1000); // Suspend the Thread in milliseconds 
			} catch (Exception e) {}
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		// By default we have the Main Thread and by default all the code use Main Thread
		System.out.println("Good"); // Main Thread
		
		// Threads run independently
		
		Hi obj1 = new Hi();
		Hello obj2 = new Hello();
		
		// Threads must have a run() method where the thread starts executing. run() method is like the main() method for the Threads.
		obj1.start(); // start() internally calls the run() method in the object
		obj2.start();
	}

}
/*
There are two ways to create a Thread in Java:
1. by creating a object of a class that extends the Thread class
2. By passing the object of a class that implements the Runnable interface to the constructor of a newly created Thread
 */

