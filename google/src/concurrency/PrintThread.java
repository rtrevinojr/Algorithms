package concurrency;

import java.util.concurrent.Semaphore;

public class PrintThread {
	
	
	public static void main (String [] args) {
		
		Semaphore one = new Semaphore (1);
		Semaphore two = new Semaphore (0);
		Semaphore three = new Semaphore (0);
		
		PrintOne printOne = new PrintOne (one, two);
		PrintTwo printTwo = new PrintTwo (two, three);
		PrintThree printThree = new PrintThree (three, one);
		
		Thread t1 = new Thread(printOne, "Print one");
		Thread t2 = new Thread(printTwo, "Print two");
		Thread t3 = new Thread(printThree, "Print three");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class PrintOne implements Runnable {
	
	Semaphore semaphoreOne;
	Semaphore semaphoreTwo;
	
	public PrintOne (Semaphore semaphoreOne, Semaphore semaphoreTwo) {
		
		super();
		this.semaphoreOne = semaphoreOne;
		this.semaphoreTwo = semaphoreTwo;
	}
	
	@Override 
	public void run () {
		
		for (int i = 1;; i += 3) {
			try {
				semaphoreOne.acquire();
				System.out.println(i);
				semaphoreTwo.release();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PrintTwo implements Runnable {
	
	Semaphore semaphoreTwo;
	Semaphore semaphoreThree;
	
	public PrintTwo (Semaphore semaphoreTwo, Semaphore semaphoreThree) {
		
		super();
		this.semaphoreTwo = semaphoreTwo;
		this.semaphoreThree = semaphoreThree;
	}
	
	@Override 
	public void run () {
		
		for (int i = 2;; i += 3) {
			try {
				semaphoreTwo.acquire();
				Thread.sleep(1000);
				System.out.println(i);
				semaphoreThree.release();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PrintThree implements Runnable {
	
	Semaphore semaphoreThree;
	Semaphore semaphoreOne;
	
	public PrintThree (Semaphore semaphoreThree, Semaphore semaphoreOne) {
		
		super();
		this.semaphoreOne = semaphoreOne;
		this.semaphoreThree = semaphoreThree;
	}
	
	@Override 
	public void run () {
		
		for (int i = 3;; i += 3) {
			try {
				semaphoreThree.acquire();
				Thread.sleep(1000);
				System.out.println(i);
				semaphoreOne.release();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
