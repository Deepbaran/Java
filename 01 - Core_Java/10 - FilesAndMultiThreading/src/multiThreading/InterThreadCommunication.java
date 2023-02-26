package multiThreading;

class A {
	int num;
	boolean valueSet = false;
	
	public synchronized void setNum(int num) { // Accessed by the Producer Thread
		while(valueSet) {
			try { wait(); } catch (InterruptedException e) {} // Tells the Consumer Thread to wait until notifying
		}
		System.out.println("Put: " + num);
		this.num = num;
		valueSet = true;
		notify(); // notifies the Consumer Thread to run
	}
	
	public synchronized void getNum() { // Accessed by the Consumer Thread
		while(!valueSet) {
			try { wait(); } catch (InterruptedException e) {} // Tells the Producer Thread to wait until notifying
		}
		System.out.println("Get: " + num);
		valueSet = false;
		notify(); // notifies the Producer Thread to run
	}
}

// First Producer will produce then the Consumer will consume
// If Producer is waiting, Consumer will notify and if Consumer is waiting then Producer will notify
// wait() and notify() must be used inside a synchronized block that is it must be Thread safe
// wait() and notify are used for InterThread Communication
// In this case even if the Producer has done it's job, it will wait for the Consumer and vice-versa
// Because until the Consumer notifies the Producer to Produce more, the Producer will wait and vice-versa.
// wait() and notify() belong to Object class.

class Producer implements Runnable {
	
	A a;
	
	Producer(A a) {
		this.a = a;
		Thread t = new Thread(this, "Producer");
		t.start();
	}
	
	public void run() {
		int i = 0;
		while(true) {
			a.setNum(i++);
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
}

class Consumer implements Runnable {
	
	A a;
	
	Consumer(A a) {
		this.a = a;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}
	
	public void run() {
		while(true) {
			a.getNum();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {}
		}
	}
}

public class InterThreadCommunication {

	public static void main(String[] args) {
		A a = new A();
		new Producer(a); // Anonymous object
		new Consumer(a);
	}

}
