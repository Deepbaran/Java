package multi.threading.thread07;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) { //providing 'this' in-place of a explicit lock object means that we are going to use the intrinsic lock of the Processor object
			System.out.println("Producer thread running ...");
			this.wait(); //Causes the current thread to wait until it is awakened, typically by being notified or interrupted. It is a method of Object class.
			//We can use just wait() too if the object we are locking on is this. Otherwise we need to explicitly use that object's wait() 
			/*
			 * As All classes are child classes of Object class, so we can use the wait() of the this object.
			 * We need to call wait() on the that object that we are locking on. Each Object has a wait() method
			 * 
			 * wait() is a lot system resource efficient, unlike while(true)
			 * 
			 * We can call wait() only within the synchronized code block.
			 * wait() actually hands over control of the lock that the synchronized block is locked on.
			 * So, at this point the synchronized block will loose control of the lock.
			 * And the thread will not resume until one of the two things happen:
			 * 1. The thread gains back control of the lock
			 * 2. Another thread locked on the same object call notify()
			 * This wait will go on until any of the above two conditions take place.
			 */
			
			System.out.println("Resumed.");
		}
	}
	
	public void consume() throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) { //We are using the intrinsic lock of the Process object. When the synchronized block releases the key due to the wait(), consumer will use the key. So, it is important that both use the same lock-key
			System.out.println("Waiting for return key.");
			scanner.nextLine();
			System.out.println("Return key pressed");
			this.notify();
			/*
			 * notify() also can only be called inside the synchronized block.
			 * Once notify() is executed, it will notify one of the threads (the 1st of the threads that are locked on the same lock object).
			 * It will notify that thread, that if it is waiting, it can wake up.
			 * 
			 * One thing to make sure is that whenever notify() is executed, we need to make sure that the lock is released otherwise the other thread will not be able to get the lock and resume again.
			 * 
			 * notifyAll() -> notifies all the threads waiting on the same lock.
			 */
			
			Thread.sleep(5000); //This wait(sleep) time shows that notify does not make the thread relinquish the lock unlike wait
			// All notify does is that, it notifies the waiting thread(s) to wake up and take the lock as soon as the current thread completes execution of the synchronized block and relinquishes the lock.
		}
	}
	
}
