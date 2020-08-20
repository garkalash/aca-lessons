package com.aca.multithreading.semaphors;

import java.util.concurrent.Semaphore;

/**
 * @author: garik
 * @created" 8/15/2020, 9:48 AM
 */

class Shared {
    static int count = 0;
}

class IncThread extends Thread {
    private Semaphore semaphore;

    public IncThread(Semaphore semaphore,  String name){
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
            System.out.println("Starting " + this.getName() + " is waiting for semaphore");
            try {
                semaphore.acquire();
                System.out.println(this.getName() + " is acquired.");
                for(int i = 0; i < 3; ++i){
                    Shared.count++;
                    System.out.println("Incremented value: " +Shared.count);
                    Thread.sleep(20);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(this.getName() + " released semaphore");
                semaphore.release();
            }
        }
}


class DecThread extends Thread {
    private Semaphore semaphore;

    public DecThread(Semaphore semaphore,  String name){
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
            System.out.println("Starting " + this.getName() + " is waiting for semaphore");
            try {
                semaphore.acquire();
                System.out.println(this.getName() + " is acquired.");
                for(int i = 3; i > 0; --i){
                    Shared.count--;
                    System.out.println("Decremented value: " +Shared.count);
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(this.getName() + " released semaphore");
                semaphore.release();
            }

    }
}





public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        IncThread c1 = new IncThread(semaphore, "incremental");
        DecThread c2 = new DecThread(semaphore, "decremental");

        c1.start();
        c2.start();
    }
}
