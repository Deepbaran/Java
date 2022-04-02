package multi.threading.thread13;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Starting.");
		
		/*
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				Random ran = new Random();
				
				for(int i = 0; i < 1E8; i++) {
					
					//Check the flag set by t.interrupt() Here Thread denoted t as we are inside the context of t thread and not the main thread
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted");
						break;
					}
					
					//try {
					//	Thread.sleep(1);
					//} catch (InterruptedException e) {
					//	System.out.println("We've been interrupted");
					//	break;
					//}
					
					
					Math.sin(ran.nextDouble());
				}
			}
		});
		
		t.start();
		
		Thread.sleep(500);
		
		//Attempting to interrupt the thread.
		t.interrupt(); 
		//This sets a interrupted flag in the thread
		//Once the flag is set, any InterruptedException that could be thrown, will be thrown as we have already set a flag denoting the thread is interrupted and throw the designated exception
		
		//Stop the thread
		//t.stop(); //deprecated
		
		t.join();
		*/
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Future<?> fu = exec.submit(new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				Random ran = new Random();
				
				for(int i = 0; i < 1E8; i++) {
					
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted");
						break;
					}
					
					Math.sin(ran.nextDouble());
				}
				return null;	
			}
		});	
		
		exec.shutdown();//Shutdown the managerial thread after all the worker threads are finished executing. Otherwise it will keep running.
		
		Thread.sleep(500);
		
		exec.shutdownNow(); //This attempt to kill all the running threads immediately
		//This is the Thread Pool way of setting the interrupted flag.
		
		//fu.cancel(true); //Same as calling t.interrupt() It will set the same exact flag.
		//false -> It will cancel the thread only if it has not already run. But if it is already running then it will not cancel the thread.
		//true -> It will set the interrupted flag after the thread started running.
		
		exec.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Finished.");
	}

}
