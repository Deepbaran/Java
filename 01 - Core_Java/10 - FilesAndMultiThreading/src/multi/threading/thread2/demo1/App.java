package multi.threading.thread2.demo1;


/*
There are two kinds of problems that we encounter if we have two threads accessing the same data.
1. First problem has to do with Data being cached
2. Second problem has to do with Threads into leaving
*/

import java.util.Scanner;

class Processor extends Thread {
	private volatile boolean running = true;
	
	public void run() {
		while(running) {
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press return to stop ...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine(); //The main thread will pause here till we hit the return key but the proc1 thread will keep on executing
		
		proc1.shutdown(); // Changing the value of running from the Main Thread
		
		/*
		 * This process might work in stopping the execution of a thread
		 * but apparently under some condition, the Processor thread may decide to cache running=true at the start
		 * In that situation, the while loop will never stop.
		 * 
		 * The reason behind it is that both the main thread and the proc1 thread are accessing running
		 * And in Java no thread expects other threads to modify it's data
		 * so when we call the shutdown method using the main thread to change the value of running, it might not affect the proc1 thread
		 * As the proc1 thread might have it's own copy of the code (cached the data of the code in the run method).
		 * The proc1 thread might think it never changed the value of running inside the run method (Actual thread code), so it might not bother with other threads changing it's value and instead cache the value of running.
		 * 
		 * To prevent this we use volatile keyword.
		 * volatile is used to stop threads from caching values of the variables when they are not changed within the run method.
		 * 
		 * So, if we want to change the variable of a thread from another thread, we have to use the volatile keyword.
		 */
	}
}





