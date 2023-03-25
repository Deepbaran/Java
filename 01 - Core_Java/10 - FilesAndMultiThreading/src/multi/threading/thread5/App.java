package multi.threading.thread5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Countdown Latches: It lets you count down from the specified number.
// Countdown latch is Thread safe. Meaning it can be accessed by multiple threads without worrying about Thread Synchronisation.
/*
 * Count down latch makes one or more threads wait till the count down becomes 0.
 * 1 or more threads can count down the latch to 0 and then 1 or more threads that are waiting on the latch can carry on their tasks.
 * CountDownLatch is a thread safe class, so we do not need to use synchronized explicitly. 
 */

class Processor implements Runnable {
	
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started ...");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();
	}
	
}

public class App {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 3; i++) {
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await(); //It waits till the count down latch count downs to 0
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		System.out.println("Completed ...");
	}

}
