package multi.threading.thread03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Drawback of synchronized is that all the synchronized methods have the same intrinsic lock,
 * so, if one thread acquired the intrinsic lock and started executing a synchronized method,
 * other threads cannot enter other synchronized methods as they need the same intrinsic lock as the first thread
 * which will be available after the 1st thread stop executing the synchronized method.
 * 
 * So, while t1 is executing, stageOne, t2 cannot execute stageTwo as t1 is holding the lock.
 * Both stageOne and stageTwo require the same lock (And there is only one if we use synchronized).
 * 
 * To solve this issue, we can create our own locks for the synchronized methods. And use synchronized blocks instead of synchronized methods.
 * 
 * With this t2 can execute stageTwo by using lock2 while t1 is executing stageOne using lock1. t2 can only access stageOne once t1 releases lock1 (done executing stageOne)
 * and vice-versa.
 * 
 * Now the threads do not need to wait for the single lock.
 * 
 * We can use any kind of object as locks for synchronized blocks but it is better to use the objects whose value will not change through out the code execution.
 * That is why we created two separate lock objects, lock1 and lock2.
 * These locks are essentially mutex (meaning, mutually exclusive).
 * mutex -> It is a locking mechanism used to synchronization access to a resource. Only one task (can be a thread or process based on OS abstraction) can acquire the mutex. It means there is ownership associated with a mutex, and only the owner can release the lock (mutex).
 *
 */

public class Worker {
	
	private Random random = new Random();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	public void stageOne() {
		synchronized (lock1) { //Providing a custom lock object to the synchronized block
			//lock1 Object is now the dedicated lock to access this synchronized block
			try {
				Thread.sleep(1); //If the code is not executing by a explicit thread, then the main thread will sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			list1.add(random.nextInt());
		}
	}
	
	public void stageTwo() {
		synchronized (lock2) { //lock1 Object is now the dedicated lock to access this synchronized block
			try {
				Thread.sleep(1); //If the code is not executing by a explicit thread, then the main thread will sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			list2.add(random.nextInt());
		}
	}
	
	public void process() {
		for(int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() {
		System.out.println("Starting ...");
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start(); 
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: " + list1.size() + "; list2: " + list2.size());
	}
}
