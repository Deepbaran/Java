package multiThreading;

class Hi1 implements Runnable {
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hi");
			try { 
				Thread.sleep(1000); // Suspend the Thread in milliseconds 
			} catch (Exception e) {}
		}
	}
}

class Hello1 implements Runnable {
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			try { 
				Thread.sleep(1000); // Suspend the Thread in milliseconds 
			} catch (Exception e) {}
		}
	}
}

public class RunnableDemo {

	public static void main(String[] args) {
		Hi1 obj1 = new Hi1();
//		Hello1 obj2 = new Hello1();
		
		Thread t1 = new Thread(obj1); // New Thread is created and the obj1 object of the Hi1 class which implements the Runnable interface is linked
//		Thread t2 = new Thread(obj2);
		
		t1.start(); // This start() method calls the run() method of the obj1 object
//		t2.start();
		new Thread(new Hello1()).start();
	}

}
