package multi.threading.thread2.demo2;

// Race condition happens when the tread executing in the critical section leaves midway and another thread steps in executes
// synchronized keyword stops race condition from happening.
/*
 * Every object in Java has a intrinsic lock or a monitor lock or mutex.
 * If we call the synchronized method of an object, we have to acquire the intrinsic lock before we can call it.
 * Only one thread can acquire the intrinsic lock at a time.
 * If one thread acquires the intrinsic lock and starts running the synchronized method and if another thread at the same time tries to call the same method
 * then the second thread has to wait until the first thread releases the intrinsic lock (by finishing the execution of the synchronized method).
 * 
 * Whenever multiple threads are trying to access shared data, always use synchronized method to avoid race condition.
 * Use volatile keyword if one thread wants to change the value of a variable of another thread.
 */

public class App {
	
	private int count = 0;
	
	public synchronized void increment() {
		//This is the Critical Section 
		count++; 
		// count++ is not an atomic operation. There are three different operations associated with it.
		// count = count + 1; -> Read count -> Increase count -> Store the increased value to count 
	}

	public static void main(String[] args) {
		App app = new App();
		app.dowork();
	}
	
	public void dowork() {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 10000; i++) {
					increment();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 10000; i++) {
					increment(); // count = count + 1;
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); //join pauses the execution of the thread where t1 was called in (In this case, main thread) till t1 is done executing.
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("count is: " + count);
	}

}
