package com.example.demo.thread;

public class HappensBeforecheck extends Thread {
	public static final int TOTAL_THREADS = 10;

	private volatile int counter = 0;
	private int increase = 0;
	int threadNo;
	public final static Object obj = new Object();

	public HappensBeforecheck(int no) {
		threadNo = no;
	}

	public void run() {
		synchronized (obj) {
			increase++;
			counter++;
			while (counter <= 100) {
				if (counter % TOTAL_THREADS == threadNo
						|| (counter % TOTAL_THREADS == 0 && TOTAL_THREADS == threadNo)) {
					System.out.println(
							Thread.currentThread().getName() + " " + this.threadNo + " printing" + " " + counter++);
					obj.notifyAll();
				} else {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= TOTAL_THREADS; i++) {
			HappensBeforecheck th = new HappensBeforecheck(i);
			th.start();
		}
	}
}
