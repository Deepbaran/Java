package multiThreading;

public class ThreadPriority {

	public static void main(String[] args) {
		Thread t1 = new Thread(
			() -> {
				for(int i = 1; i <= 5; i++) {
					System.out.println("Hi" + Thread.currentThread().getPriority()); // currentThread() refers to the current thread
					try { 
						Thread.sleep(1000); 
					} catch (Exception e) {}
				}
			}); // Thread object implementing Runnable interface
			
		Thread t2 = new Thread(
			() -> {
				for(int i = 1; i <= 5; i++) {
					System.out.println("Hello");
					try { 
						Thread.sleep(1000);
					} catch (Exception e) {}
				}
			}, "Hello Thread"); // Thread object implementing Runnable interface, set Thread name
		
		t1.setName("Hi Thread");
//		t2.setName("Hello Thread");
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		
		// All Threads have default Priority 5 (normal). Range of priority goes from 1 (least) to 10 (highest)
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		
//		t1.setPriority(1);
		t1.setPriority(Thread.MIN_PRIORITY); 
//		t2.setPriority(10);
		t2.setPriority(Thread.MAX_PRIORITY);
		// MIN_PRIORITY = 1, NORM_PRIORITY = 5, MAX_PRIORITY = 10
		
		t1.start();
		t2.start();
	}	

}
