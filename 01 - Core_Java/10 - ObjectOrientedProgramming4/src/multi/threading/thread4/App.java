package multi.threading.thread4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Thread Pools - A way of managing lots of threads together
/*
 * A thread pool is like having workers in a factory
 * and we want to make them do some tasks.
 * The workers will work on different tasks and once any one of them is done with their task, it will start working on a new task.
 * It's like telling factory workers, "Here are a bunch of tasks, start working one them. Once you are done with one please start a new one".
 * 
 * There is a lot of overhead of starting a thread and by recycling the threads in the thread pool, we avoid that overhead.
 */

class Processor implements Runnable {
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting: " + this.id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed: " + this.id);
	}
}

public class App {

	public static void main(String[] args) {
		
		// Creating 2 threads using ExecutorService (Thread Pool)
		ExecutorService executor = Executors.newFixedThreadPool(2); //Creating 2 worker threads
		// executor have it's own managerial thread that will the handle passing out the submitted tasks among the worker threads.
		
		for(int i = 0; i < 5; i++) {
			executor.submit(new Processor(i)); //submitting a task to executor
		}
		
		executor.shutdown(); //I want my program to terminate once all the worker threads are done executing
		//Telling the managerial thread in the executor to shutdown and stop accepting any more tasks
		//With this managerial thread will not submit any new task for now.
		//This will not shutdown the managerial thread immediately.
		//Managerial thread will wait for all the worker threads to complete what they were doing before getting shutdown. Then the worker threads will terminate.
		
		System.out.println("All tasks submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS); //Wait for 1 day for all the worker threads to complete their tasks at max. And regardless if they are done with their task or not, after 1 day terminate them.
			//Without this, executor would have submitted more tasks before properly terminating the active worker threads.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		System.out.println("All tasks completed");
	}

}
