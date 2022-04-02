package multi.threading.thread11;

import java.util.concurrent.Semaphore;

public class Connection {

	//Singleton Class
	
	private static Connection instance = new Connection();

	//Trying to limit the number of threads (or connections) at any given point of time using Semaphores
	private Semaphore sem = new Semaphore(10, true); 
	//There are only 10 permits. So, only 10 threads can access this at the same time, so there can be 10 connections.
	//The 2nd operator is a fairness parameter. If it is true then that means whichever thread called the acquire first will get the permit once it is available.
	//Having the fairness parameter set to true is a good idea, because if it is fales then some threads might again and again acquire the permit while some threads 
	//might never acquire the permit and cause starvation.
	
	private int connections = 0; //number of connections made at any given moment.
	
	private Connection() {}
	
	public static Connection getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try {
			doConnect();
		} finally {
			//We are putting release in finally because even if doConnect() throws an error, the thread will atleast release the permit it was holding.
			sem.release();
		}
	}
	
	public void doConnect() {
		
		synchronized (this) {
			connections++;
			System.out.println("Current connections: " + connections);
		}

		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;
			System.out.println("Current connections: " + connections);
		}
				
	}

}
