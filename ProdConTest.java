package com.example.demo.thread;

import java.util.LinkedList;
import java.util.Queue;

class PC {

	private volatile Queue<Integer> queue;
	int capacity;

	public PC(int capacity) {
		this.capacity = capacity;
		queue = new LinkedList<>();
	}

	public void producer() {
		 int count = 0;
		while (true) {
		synchronized (queue) {
			     while(queue.size() == capacity) {
					try {
						queue.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " producing " + count);
				
				queue.add(count++);
				queue.notify();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	public void consumer() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == 0) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int i = queue.remove();
				System.out.println(" Queuue size in consumer " + queue.size());
				System.out.println(Thread.currentThread().getName() + " consuming " + i);

				queue.notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

public class ProdConTest {

	public static void main(String[] args) {
		PC pc = new PC(3);
		Runnable producer = new Runnable() {

			@Override
			public void run() {
				//for (int i = 0; i < 100; i++)
					pc.producer();
			}
		};

		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				pc.consumer();
			}
		};

		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();

	}

}
