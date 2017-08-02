package ThreadsNotify;

import java.util.Random;

//Creates a class Manufacturer and extend this class With Runnable Interface.
public class Manufacturer implements Runnable {

	private Notify notify; //Declaring Notify class variable 

	public Manufacturer(Notify notify) {  //Creating Manufacturer class Method 
    	
		this.notify = notify;// Gives reference to the current objects of the method 
	}

	public void run() {  //Run method of runnable interface 
		Random random = new Random();//Creates Random class object.
		while (true) { //While Statement
			int num = random.nextInt(50); /**Assigning num variable by Random class method which 
			                              returns the random integer value upto 50.
			                              **/
			try { //Try statement
				
				//Pause to ensure all waiting thread started successfully.
				Thread.sleep(random.nextInt(1000)); 
				notify.put(num); //Calling put function of notify class and assigning random value. upto 50.
			} catch (InterruptedException e) { //Catch statement 
			}
		}
	}
}
