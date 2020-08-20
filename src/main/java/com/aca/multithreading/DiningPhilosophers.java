package com.aca.multithreading;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author: garik
 * @created: 8/20/2020, 10:25 PM
 */
public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 10;

    public static void main(String[] args) {
        Semaphore[] items = new Semaphore[NUM_PHILOSOPHERS];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher( items[i], items[(i+1) % NUM_PHILOSOPHERS], i);
            new Thread(philosophers[i]).start();
        }
    }

}

class Philosopher implements  Runnable{
    private Semaphore left;
    private Semaphore right;
    private Integer id;

    private final Random randomGen = new Random();


    @Override
    public void run() {
        try{
            while (true){
                think();
                pickLeft();
                pickRight();
                eat();
                releaseItems();
            }
        } catch (InterruptedException ex){
            System.out.println("Philosopher " + id + " was interrupted.");
        }
    }

    public Philosopher(Semaphore left, Semaphore right, Integer id) {
        this.left = left;
        this.right = right;
        this.id = id;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is THINKING");
        Thread.sleep(5 * 1000L);
    }

    private void pickLeft() throws InterruptedException {
        if(left.availablePermits() == 0){
            System.out.println("Philosopher " + id + " is WAITING");
        }

        left.acquire();
        System.out.println("Philosopher " + id + " is HOLDING");
    }

    private void pickRight() throws InterruptedException {
        if(right.availablePermits() == 0){
            System.out.println("Philosopher " + id + " is WAITING");
        }

        right.acquire();
        System.out.println("Philosopher " + id + " is HOLDING");
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is EATING");
        Thread.sleep(randomGen.nextInt(5) * 1000L);
    }

    private void releaseItems (){
        System.out.println("Philosopher " + id + " is RELEASING");
        left.release();
        right.release();
    }
}
