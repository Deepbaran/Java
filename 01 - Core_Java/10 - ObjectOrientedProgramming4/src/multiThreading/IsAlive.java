package multiThreading;

public class IsAlive {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(
			() -> {
				for(int i = 1; i <= 5; i++) {
					System.out.println("Hi");
					try { 
						Thread.sleep(1000); 
					} catch (Exception e) {}
				}
			});
		
		Thread t2 = new Thread(
			() -> {
				for(int i = 1; i <= 5; i++) {
					System.out.println("Hello");
					try { 
						Thread.sleep(1000);
					} catch (Exception e) {}
				}
			});
		
		t1.start();
		t2.start();
		
		System.out.println(t1.isAlive()); // true // Check if the Thread is alive or not
		
		t1.join(); // As soon as t1 Thread completes it's work it joins with the main Thread
		t2.join();
		
		// If there is a thread that is using the join method then the Main Thread will wait for the Thread to join it before executing any further code
		// Once compiler hits the join method, it waits for the Thread to join the Main Thread before moving to the next line
		
		System.out.println("Bye"); // This will be executed after the Threads are joined with the Main Thread as join method is applied
		System.out.println(t1.isAlive()); // false
	}

}
