package multi.threading.thread09;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Re-entrant locks are an alternative to synchronized keyword.
 * 
 * Rentrant lock means that, once a thread acquires the lock (locked the lock), it can lock it again if it wants to.
 * And the lock keeps a count of how many times it has been locked, and the we need to unlock it by the same number of times.
 * Normally the locking happens one.
 */

public class Runner {
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	private void increment() {
		for(int i = 0; i < 10000; i++ ) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException {
		
		/*
		lock.lock(); //While one thread locked the lock, another thread cannot use it
		//This is not a good way to implement it. Because if the code in here throws an exception out of the method, we will never be able to unlock the lock.
		increment();
		lock.unlock(); //Unlocking the locked lock
		*/
		
		lock.lock();
		
		System.out.println("Waiting ...");
		cond.await(); //It is equivalent to wait() in synchronized block. It must be called after the lock has been locked. Unlike wait() it does not belong to the object that locked the lock, rather it belongs to a class called Condition
		
		System.out.println("Woken up!");
		
		try {
			increment();
		} finally {
			lock.unlock(); //In this way, even if the code throws an exception, the lock will get unlocked.
		}
	}
	
	public void secondThread() throws InterruptedException {
		
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");
		
		cond.signal(); //This is equivalent to notify(). Just like await()
		
		try {
			increment();
		} finally {
			lock.unlock(); //We must unlock after signal is called. Otherwise once the awaiting thread wakes up due to the signal(), it will not be able to reacquire the lock as it was never unlocked.
		}
	}
	
	public void finished() {
	
		System.out.println("Count is: " + count);
	}
}
