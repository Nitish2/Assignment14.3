package ThreadsNotify;

/**
 * The notify() method is generally used for resource pools, 
 * where there are number of threads that take resources, 
 * but when a resource is added to the pool, only one of the waiting thread can deal with it.
 * @author Hp
 *
 *The notifyAll() method is actually used in most other cases instead of notify() because,
 *it is often difficult to know exactly what threads will be waiting on a particular object.
 *
 */

public class Notify {
    //Declaring variables 
	int num;
	private boolean empty = true;
	private boolean evenNum = false;

	/*
	 * Creating synchronized method get . 
	 * This is where customer tries to acquire the lock.
	 */ 
	public synchronized int get(final boolean ev) {
         //If we didn't  use while loop, we would get an IndexArrayOutOfBoundsException.
		while (empty || evenNum != ev) { // Called when no request is waiting 
			//Using ( ? ) ternary operator or conditional operator for condition . 
			try { 
				System.out.format("%s thread is waiting %n", ev ? "Even" : "Odd");//Prints message
				wait();  //Calling Wait method 
			} catch (InterruptedException e) {
			}
		}
		System.out.format("%s fetched %d \n", ev ? "Even" : "Odd", num);
		
		empty = true;  //condition sets to true
        // Called when there are any getters or putters waiting
		notifyAll();
		// notify();
		return num; // Returns the num value
	}

	public synchronized void put(int n) { //Creating synchronized put method 
		while (!empty) { //Called when request is waiting 
			try {
				System.out.println("Manufacturer thread is waiting");
				wait(); //Calling Wait method 
			} catch (InterruptedException e) {
			}
		}
		this.num = n; // Reference to the object num.
		evenNum = n % 2 == 0;  // Number will be even if the remainder is zero .
		System.out.format("Manufacturer insert %d \n", n); //Prints message
		empty = false; //condition sets to false
		
		// Called when there are any getters or putters waiting
		notifyAll();
		//notify();
	}

}
