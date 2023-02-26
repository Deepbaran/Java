package multi.threading.thread6;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//The Classes under the concurrent package are Thread safe

public class App {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	// ArrayBlockingQueue is a data structure which can hold data items of your choosing
	// It's a thread safe queue
	
	public static void main(String[] args) {
		/*
		 * Idea of Produce-Consumer Patterns:
		 * We have one or more threads that are producing things.
		 * Those threads add things to a common data share like the queue here.
		 * And then other threads remove things from the queue and then process it.
		 * 
		 * Basically some threads produce some data to the queue (Producers).
		 * And then some threads take (consume) data from the queue to process it (Consumers).
		 * 
		 * eg:
		 * Producer can be a thread that takes text messages from the sender and stores them in the queue
		 * Then Consumer takes those messages from the queue and sends them to their destination.
		 */
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				producer();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				consumer();
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
	}

	private static void producer() {
		Random random = new Random();
		
		while(true) {
			try {
				queue.put(random.nextInt(100)); //Random number from 0 to 99
				//If queue is full then put() will wait till there is empty space
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void consumer() {
		Random random = new Random();
		
		while(true) {
			try {
				Thread.sleep(100); //We want the consumer to consume data from queue every 100 milliseconds.
			
				if(random.nextInt(10) == 0) { //It's true every 1 out of 10 times
					Integer value = queue.take();
					/*
					 * put and take both are synchronized as they are in a Thread safe class
					 * If there are nothing to take, then take() will wait till there is something to take.
					 */
					
					System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
