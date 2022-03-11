package threadconcept;

public class ParallelExecute extends Thread {

	public ParallelExecute() {
		System.out.println("thred is executing t1...");
	}

	public void run() {
		System.out.println("inside run method...");

	}

	public static void main(String[] args) {
		ParallelExecute t1 = new ParallelExecute();
		ParallelExecute t2 = new ParallelExecute();
		ParallelExecute t3 = new ParallelExecute();

		System.out.println("default priority :" + t1.getPriority());
		System.out.println("default priority :" + t2.getPriority());
		System.out.println("default priority :" + t3.getPriority());

		t1.setPriority(2);//21 illegal argument exception
		t2.setPriority(MAX_PRIORITY);// 10
		t3.setPriority(NORM_PRIORITY);// 5
		
		 // t1.start();//constructor called t2.start(); t3.run();
		 
		System.out.println("updated priority :" + t1.getPriority());
		System.out.println("updated priority :" + t2.getPriority());
		System.out.println("updated priority :" + t3.getPriority());

		System.out.println("updated name :" + t1.getName()); //thread-0
		System.out.println("updated name :" + t2.getName());
		System.out.println("updated name :" + t3.getName());

		System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());

		System.out.println("Main thread priority : " + Thread.currentThread().getPriority());

		// Main thread priority is set to 10
		Thread.currentThread().setPriority(10);

		System.out.println("Main thread priority : " + Thread.currentThread().getPriority());

		t1.start();
		t2.start();
		t3.start();
		t2.stop();
		}

}
