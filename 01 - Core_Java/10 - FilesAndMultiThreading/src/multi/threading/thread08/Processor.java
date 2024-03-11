package multi.threading.thread08;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Processor {
	
	// Shared data
	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException {
		//add items to the store (list)
		
		int value = 0;
		
		while(true) {
			
			synchronized (lock) {
				//The code that accessed the shared data has to be synchronized
				
				while(list.size() == LIMIT) {
					lock.wait();
				}
				
				list.add(value++);	
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {
		//remove items from the store (list)
		
		Random random = new Random();
		
		while(true) {
			synchronized (lock) {
				
				while(list.size() == 0) {
					lock.wait();
				}
				
				System.out.print("List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println("; value is: " + value);
				lock.notify();
			}
			
			Thread.sleep(random.nextInt(1000));
		}
	}
	
}
