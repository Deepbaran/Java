package multi.threading.thread11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 * Semaphore -> It is an object that maintains a count. And the number of counts refer to the number of available permits of the semaphore.
 * acquire and release of 1 permit in a semaphore is like a lock.
 * So, a semaphore with one permit is basically a lock. 
 * The only difference is, you can happily release from different threads, to where you did the acquire. Unlike lock, where we ned to unlock from the same thread, 
 * here we do not have that restriction.
 * 
 * Semaphores are usually used to control access to some resource.
 */

public class App {

	public static void main(String[] args) throws InterruptedException {
		/*
		Semaphore sem = new Semaphore(1);
		
		//sem.release(); //Increases the number of available permits
		//sem.acquire(); //Decreases the number of available permits. acquire() will wait till a permit is available
		
		//Simulating a lock using Semaphore
		sem.acquire();
		//critical section
		sem.release();
		
		System.out.println("Available permits: " + sem.availablePermits());
		*/
		
		
		
		//Always ExecutorService whenever you need to create a bunch of threads
		ExecutorService executor = Executors.newCachedThreadPool();
		//newCachedThreadPool -> It is a thread pool in which everytime we call submit in the executor, it creates a new thread (if it was not able to assign a idle thread).
		
		for(int i = 0; i < 2000; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		
		executor.shutdown();
		
		executor.awaitTermination(1, TimeUnit.DAYS);
	}

}
