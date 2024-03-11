package multi.threading.thread01.demo3;

public class App {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() { //Building Threads using Anonymous class

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
			
		});
		
		t1.start();
	}

}
