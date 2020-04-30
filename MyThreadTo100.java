package com.example.demo.thread;

/*//Here is a solution for the problem.
The current thread acquire the lock 
and we decide if the thread is eligible to execute (printing the number here). 
If so perform the operation and notify all threads that they can try now. Else wait till its notified by other threads.*/

public class MyThreadTo100 extends Thread {

//define the Total No.Of Threads needed
	public static final int TOTAL_THREADS = 10;

	public final static Object obj = new Object();

	int threadNo;
	static volatile int counter = 1;

	public MyThreadTo100(int threadNo) {
		this.threadNo = threadNo;
	}

	@Override
	public void run() {

		// in a synchronized block to acquire lock
		synchronized (obj) {

			while (counter <= 100) {

				/*
				 * counter==threadNo => To print the initial numbers till TOTAL_THREADS
				 * counter%TOTAL_THREADS == threadNo => e.g 11%10 = 1 -> 1 will print this,
				 * 12%10 = 2 .. (counter%TOTAL_THREADS == 0) && (TOTAL_THREADS == threadNo) =>
				 * 10%10 will be 0, and this must be printed by 10 th thread only, ie the
				 * highest thread.
				 */
				if ((counter % TOTAL_THREADS == threadNo)
						|| ((counter % TOTAL_THREADS == 0) && (TOTAL_THREADS == threadNo))) {

					// Display the output as desired
					System.out.println(Thread.currentThread().getName()+ " " +this.threadNo + " printing" + " " + counter++);

					// notify
					obj.notifyAll();
				} else {

					// current thread not eligible for printing the current counter value, so wait
					// till its notified
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public static void main(String args[]) {

		/*
		 * Creating as many threads as needed.
		 */
		for (int i = 1; i <= TOTAL_THREADS; i++) {
			MyThreadTo100 th = new MyThreadTo100(i);
			th.start();
		}
	}
}