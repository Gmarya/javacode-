package com.example.demo.thread;

import java.time.Instant;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class DemoThreadWithLatchAndBarrier implements Runnable {

	private CyclicBarrier barrier;
	private CountDownLatch latch;

	public DemoThreadWithLatchAndBarrier(CyclicBarrier barrier, CountDownLatch latch) {
		this.barrier = barrier;
		this.latch = latch;
	}

	@Override
	public void run() {
		//latch.countDown();
		try {
			barrier.await();
			System.out.println(Instant.now() + "  " + Thread.currentThread().getName());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		int count = 10;
		CyclicBarrier barrier = new CyclicBarrier(count);
		CountDownLatch latch = new CountDownLatch(count);
		Phaser phaser = new Phaser(count);
		DemoThreadWithLatchAndBarrier d = new DemoThreadWithLatchAndBarrier(barrier, latch);
		ExecutorService service = Executors.newFixedThreadPool(count);
		//Using latch;
		for (int i = 0; i < count; i++) {
			service.execute(() -> {
				latch.countDown();
				try {
					latch.await();
					System.out.println(Instant.now().toEpochMilli() + "  " + Thread.currentThread().getName());
				} catch (InterruptedException e) {

				}
			});
		}
		
	/*	//Using phaser 
		for (int i = 0; i < count; i++) 
			service.execute(() -> {
				phaser.arrive();
				phaser.awaitAdvance(0);
				System.out.println(System.currentTimeMillis() + "  " + Thread.currentThread().getName());
			} );*/
		
		/*System.out.println("**********************************************");
		for (int i = 0; i < count; i++) 
			service.execute(d);*/
		service.shutdown();
	}
}