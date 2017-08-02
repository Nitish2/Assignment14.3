package ThreadsNotify;

import java.util.Random; 

/**
 * Difference between notify() and notifyAll() .
 * @author Hp
 * Notify wakes any one thread in the wait set and notifyAll wakes all threads in the waiting set.
 */

//Creates a class customer and extend this class With Runnable Interface.
public class Customer implements Runnable {
	

	private Notify notify;  //Declaring Notify class variable 
    private boolean ev;    // Declaring boolean variable 

	public Customer(boolean ev, Notify notify) { //Creating customer class Method 
	    	
		// Gives reference to the current objects of the method 
		    this.ev = ev;     	
            this.notify = notify;
	    }

	    public void run() { //Run method of runnable interface 
	    	 Random random = new Random(); //Creates Random class object ,it returns the random int value. 
	        while (true) { //While condition 
	        	notify.get(ev); // Calling get function of Notify class 
	            try {   //Try and catch statement 
	            	
	            	//Pause to ensure all waiting thread started successfully.
	            	Thread.sleep(random.nextInt(1000)); 
	            } catch (InterruptedException e) { } //Catch statement 
	        }
	    }
	}


