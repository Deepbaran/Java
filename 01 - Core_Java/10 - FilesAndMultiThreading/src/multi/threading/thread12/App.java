package multi.threading.thread12;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Callable and Future are two classes that enables you to get returnable from your threads
 * and they also allow your thread code to throw exceptions.
 * 
 * With simple Runnable, we are unable to return a particular value from a thread.
 * But with Callable we can.
 * 
 * Callable is a generic interface and the type we specify, us the type that we want to return.
 * 
 * Future is used to get the data that is returned by Callable. The type specified should be same as the type of the Callable.
 *
 * Future and Callable are a great way to use with ExecutorService (Thread pools) to add extra features and also some normal features that normal threads have (e.g: Interrupting).
 */

public class App {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		/*
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
				
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				System.out.println("Starting ...");
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Finished ...");
			}
		});
		*/

		//Suppose you want to use some methods of future but you don't want to return a result. Use wild card type (?) as the return type of Future and Void for return type of callable and simply return null.
		/*
		Future<?> future = future = executor.submit(new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				return null;
			}
		});
		*/
		
		//Getting the returned value from the Callable using Future		
		Future<Integer> future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if(duration > 2000) {
					//Even though we are throwing IOException, it will be caught as ExecutionException
					throw new IOException("Sleeping for too long.");
				}
				
				System.out.println("Starting ...");
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Finished ...");
				
				return duration;
			}
			
		});
		
		executor.shutdown();
				
		//Cancel the thread
		//future.cancel(true); //true -> Cancel the thread; false -> Let it run
		
		//Telling if thread is done or not
		//future.isDone();
		
		try {
			System.out.println("Result is: " + future.get());
			//If we do not wait for our threads to complete execution and call get(), it will block execution till the threads associated with future have terminated.
			//So, we don't need executor.awaitTermination() in this case.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			//Any kind of exception that gets raised inside Callable will be caught here except InterruptedException
			System.out.println(e);
			System.out.println(e.getMessage());
			
			/*
			//Just get the message
			//Casting the ExecutionException to IOException type (As we are manually throwing it)
			IOException ex = (IOException) e.getCause();
			System.out.println(ex.getMessage());
			*/
			
		};
	}

}
