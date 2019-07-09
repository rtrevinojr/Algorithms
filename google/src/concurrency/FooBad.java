package concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class FooBad {
	
	public int pauseTime = 1000;
	public ReentrantLock lock1;
	public ReentrantLock lock2;
	
	public FooBad () {
		
		try {
			lock1 = new ReentrantLock ();
			lock2 = new ReentrantLock ();
			
			lock1.lock();
			lock2.lock();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void first () {
		
		try {
			System.out.println("First");
			
			
		}
	}

}
