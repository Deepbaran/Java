package multi.threading.thread1.demo2;

class Runner implements Runnable {

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
		Thread t1 = new Thread(new Runner()); // Implemented Runnable and passed it to the constructor of the Thread class
		Thread t2 = new Thread(new Runner()); // Implemented Runnable and passed it to the constructor of the Thread class
		
		t1.start();	
		t2.start();
	}

}
