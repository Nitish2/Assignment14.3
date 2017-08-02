package ThreadsNotify;

public class NotifyMain {

	private static boolean Even = true;
	private static boolean Odd = false;

	public static void main(String[] args) {
		Notify notify = new Notify();
		Thread thread1 = new Thread(new Customer(Even, notify));
		Thread thread2 = new Thread(new Customer(Odd, notify));
		Thread thread3 = new Thread(new Manufacturer(notify));

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
