package com.example.demo.thread;

class NumberCLass {
	private static final int MAX = 20;
	public boolean moreThan10 = false;
	int count = 1;
	public NumberCLass() {
		// TODO Auto-generated constructor stub
	}
	synchronized public void print1to10() {
		while (count <= MAX) {
		while (!moreThan10) {
			try {
				System.out.println(Thread.currentThread().getName() + "Waiting in 1 to 10  : " + count);
				wait();
				System.out.println(Thread.currentThread().getName() + "notified  : " + count);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " print1to10 " + count);
		count ++;
		if (count <= 10) 
		moreThan10 = false;
		 
		 
		notify();
	}
	}
	synchronized public void print11to20() {
		while (count <= MAX) {
		while (moreThan10) {
			try {
				System.out.println(Thread.currentThread().getName() + "Waiting in 11 to 20  : " + count);
				wait();
				System.out.println(Thread.currentThread().getName() + "notified 11 to 20 : " + count);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " print11to20 " + count);
		count ++;
		if (count > 10)
		moreThan10 = true;
		notify();
	}
	}
}

class Print1to20 implements Runnable {
	NumberCLass n;
    private boolean lessthan10;
	public Print1to20(NumberCLass m, boolean flag) {
		n = m;
		lessthan10 = flag;
	}

	@Override
	public void run() {
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (!lessthan10) {
			n.print11to20();
		} else {
			n.print1to10();
		}
		}
	}

public class TestThreads {
	public static void main(String[] args) throws InterruptedException {
		NumberCLass n = new NumberCLass();
		Print1to20 t = new Print1to20(n, false);
		Print1to20 t11 = new Print1to20(n, true);
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t11);
		t1.setName("1-10");
		t2.setName("11-20");
		t1.start();
		t2.start();
         
		System.out.println(Thread.currentThread().getName());
	}
}