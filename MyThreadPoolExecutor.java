package com.example.demo.thread;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class SimpleThreadPoolExecutor {
	WorkerThread[] threads;
	BlockingQueue<Runnable> tasks;

	public SimpleThreadPoolExecutor(int numThreads) {
		tasks = new LinkedBlockingQueue<>();
		threads = new WorkerThread[numThreads];
		for (int i = 0; i < numThreads; i++) {
			threads[i] = new WorkerThread();
			threads[i].start();
		}

	}

	public void execute(Runnable r) {
		synchronized (tasks) {
			tasks.add(r);
			tasks.notify();
		}

	}

	class WorkerThread extends Thread {

		@Override
		public void run() {
			while (true) {
				synchronized (tasks) {
					while (tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
						}
					}
					Runnable r = tasks.poll();
					System.out.println("Current thread running " + Thread.currentThread().getName());
					tasks.remove(r);
				}
			}
		}

	}
}

public class MyThreadPoolExecutor {

	public static void main(String[] args) {
		SimpleThreadPoolExecutor s = new SimpleThreadPoolExecutor(3);
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
		      System.out.println("Yes I'm working");
				
			}
		};
		for (int i = 0 ;i < 100 ; i++) {
			System.out.print(i + " ");
			s.execute(r);
		}
	   System.out.println("_________________________________________________________________________________________");
	    Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		threadSet.forEach(action -> System.out.println(action.getName()));
		  System.out.println("_________________________________________________________________________________________");
	}

}
