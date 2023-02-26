package multi.threading.thread1.demo1;

class Runner extends Thread {

	@Override
	public void run() {
		// The code in here will run on a separate thread
		
		for(int i = 0; i < 10; i++) {			
			System.out.println("Hello " + i);
			
			try {
				Thread.sleep(100); // Pauses the code for 100 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
}

public class App {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		// If we use runner.run() then our code will run in the main Thread
		// runner1.start() tells the compiler to go look for the run method and run it on it's own separate thread
	

		Runner runner2 = new Runner();
		runner2.start();
	}

}

/*
There are two ways to create a Thread in Java.
1. Extend the Thread class
2. Implement Runnable and pass it to the constructor of the Thread class

There is another way of creating threads, using ExecutorServices, if you want your Threads to be in a Thread Pool.
*/