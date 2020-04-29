package com.example.demo.thread;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Print1to100.setSequence();
        for(int i = 1; i <= 10; i++) {
            Thread t = new Thread(new Print1to100(i));
            t.setName(i + "");
            t.start();
        }
    }
}

class Print1to100 implements Runnable {
    private static HashMap< String, String> sequence = new HashMap<String, String>();

    public static final Object lock = new Object();
    public static String turn = "1"; 
    private int startValue = 0;
    private volatile int  counter = 1;

    public Print1to100(int startValue){
        this.startValue = startValue;
    }

    @Override
    public void run() {
        while (counter != 10){
            synchronized (lock) {
                if(Thread.currentThread().getName().equals(turn)){  
                    System.out.print(startValue + " ");
                    startValue += 10;
                    counter++;
                    turn = getNextTurn(turn);
                    try {
                    	lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{                       
                    try {
                    	lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
            }
        }
    }

    public static void setSequence(){
        for (int i = 1; i <= 10; i++)
            if (i == 10)
                sequence.put(i + "", 1 + "");
            else
                sequence.put(i + "", (i + 1) + "");
    }

    public static String getNextTurn(String currentTurn){
        return sequence.get(currentTurn);
    }
}