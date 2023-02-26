package lambda_expressions;

public class ThreadDemo {

	public static void main(String[] args) {
		
		// First Thread: Thread - JOHN
		// as Runnable is a Functional Interface, so we can use lambda instead of anonymous class
		Runnable t1 = () -> {
			//this is body of the Thread
			for(int i = 0; i <= 10; i++) {
				System.out.println("Value of i is " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t = new Thread(t1);
		t.setName("JOHN");
		t.start();
		
		
		Runnable t2 = () -> {
			
			try {
				for(int i = 0; i <= 10; i++) {
					System.out.println(i*2);
					Thread.sleep(2000);;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Thread t22 = new Thread(t2);
		t22.start();
	}

}
