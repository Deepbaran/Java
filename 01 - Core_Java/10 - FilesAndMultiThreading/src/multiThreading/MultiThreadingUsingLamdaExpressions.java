package multiThreading;

public class MultiThreadingUsingLamdaExpressions {

	public static void main(String[] args) {
		// Anonymous Class
		/*
		Runnable obj1 = new Runnable() { // Runnable Object
			public void run() {
				for(int i = 1; i <= 5; i++) {
					System.out.println("Hi");
					try { 
						Thread.sleep(1000); 
					} catch (Exception e) {}
				}
			}
		};
		*/
		
		// Lambda Expression
		/*
		Runnable obj2 = () -> {
				for(int i = 1; i <= 5; i++) {
					System.out.println("Hello");
					try { 
						Thread.sleep(1000);
					} catch (Exception e) {}
				}
			};
		*/
			
		Thread t1 = new Thread(
			new Runnable() {
				public void run() {
					for(int i = 1; i <= 5; i++) {
						System.out.println("Hi");
						try { 
							Thread.sleep(1000); 
						} catch (Exception e) {}
					}
				}
			}); // Thread using Anonymous Class
		
		Thread t2 = new Thread(
			() -> {
				for(int i = 1; i <= 5; i++) {
					System.out.println("Hello");
					try { 
						Thread.sleep(1000);
					} catch (Exception e) {}
				}
			}); // Thread using Lambda Expressions
		
		t1.start();
		t2.start();
	}

}

// We can use Lambda Expressions on FunctionalInterfaces
