package multiThreading;

class Counter {
	int count;
	
	// Using synchronized keyword means that this method is now synchronized. That means if t1 is working with this method then t2 has to wait and vice versa
	// So, maximum one thread can work with it now
	// Methods that are not synchronized, are not Thread safe. That means that the class is not Thread safe.
	// Not Thread safe means that multiple Threads can access the method and data at the same time.
	public synchronized void increment() {
		count++; // count = count + 1. Two actions: addition and assignment
	}
}

public class SynchronizedKeyword {

	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		
		Thread t1 = new Thread(
				() -> {
					for(int i = 1; i <= 1000; i++)
						c.increment();
				});
		
		Thread t2 = new Thread(new Runnable() {
					public void run() {
						for(int i = 1; i <= 1000; i++)
							c.increment();
					}
				});
		
		t1.start();
		t2.start();
		
		t1.join();
		
		System.out.println("Count " + c.count);
	}

}

// If multiple Threads are accessing the same data at the same time then use synchronized to synchronize the access of the data for the Threads.
// If not synchronized then one thread can update the data while another thread was working with it.
// So, stop the thread from interfering with each other we need to synchronize them.