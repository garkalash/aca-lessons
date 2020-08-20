package com.aca.multithreading.race;

/**
 * @author: garik
 * @created" 8/13/2020, 8:55 PM
 */
class Counter {
    private volatile Long count = 0L;

    private Object DUMMY = new Object();

    public void nonSynchronized(String message){
        System.out.println("Hello from non synchronized " + message + "  " + Thread.currentThread().getName());
    }

    public synchronized void addCount(long value){
        System.out.println("Count " + count);

        if(count + value <= 101){
            System.out.println("Thread " + Thread.currentThread().getName() + " adds count " + count + " by " + value);
            count += value;
        }
    }

    public Long getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            while (counter.getCount() <= 100){
                    counter.addCount(1);
            }
        });
        Thread t2 = new Thread(() -> {
            while (counter.getCount() <= 100){
                    counter.addCount(1);
            }
        });
        Thread t3 = new Thread(() -> {
            while (counter.getCount() <= 100){
                    counter.addCount(1);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
