package multi.threading.thread10;

/*
 * Deadlock can occur if you lock your locks in different orders and it can happen not only with reentrant locks, but also with nested Synchronized locks. 
 * 
 * There are two ways to prevent deadlock from happening:
 * 1. Always lock your locks in same order.
 * 2. Have a method that can acquire locks in any order and never cause deadlock
 */

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private Account acc1 = new Account();
	private Account acc2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
		while(true) {
			// Acquire locks
			
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			
			try {
				gotFirstLock = firstLock.tryLock(); //return true if acquired the lock, otherwise return false
				gotSecondLock = secondLock.tryLock();
			} finally {
				//Stopping locks from getting partially locked
				//Prevents deadlock
				if(gotFirstLock && gotSecondLock) {
					return;
				} else if(gotFirstLock) {
					//If got only the first lock and did not get the second lock then unlock the first lock, so that it does not get partially locked 
					//and because of it some other thread stops executing because it needed the first lock.
					firstLock.unlock(); 
				} else if(gotSecondLock) {
					secondLock.unlock();
				}
			}
			
			// Locks not acquired
			Thread.sleep(1);
			
		}
	}
	
	public void firstThread() throws InterruptedException {
		
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			
			//lock1.lock(); //thread 1 acquired lock1
			//lock2.lock(); //thread 1 acquired lock2
			acquireLocks(lock1, lock2);
			try {
				Account.transfer(acc1, acc2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void secondThread() throws InterruptedException {
		
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			
			/*
			 lock2.lock();
			 lock1.lock();
			 //This will cause deadlock to occur. As in this order, thread2 will acquire lock2 and thread1 will acquire lock1
			 //But when the thread1 will need to acquire lock2, it will not be able to acquire it, as thread2 has it and similarly thread 2 will not be able to acquire lock1
			 //This will create a deadlock.
			 */
			//Correct order:
			//lock1.lock(); //thread 2 acquired lock1
			//lock2.lock(); //thread 2 acquired lock2
			acquireLocks(lock2, lock1);
			try {
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void finished() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
	}
}
