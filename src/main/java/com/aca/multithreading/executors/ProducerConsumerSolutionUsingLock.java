package com.aca.multithreading.executors;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: garik
 * @created" 8/15/2020, 10:43 AM
 */

class Products {

    private static final int CAPACITY = 10;
    private final Queue<Integer> products = new LinkedList<>();

    private final Lock aLock = new ReentrantLock();
    private final Condition bufferNotFull = aLock.newCondition();
    private final Condition bufferNotEmpty = aLock.newCondition();


    public void put() throws InterruptedException {
        aLock.lock();

        try{
            while (products.size() == CAPACITY) {
                System.out.println("Products Bin is full, Thread name " + Thread.currentThread().getName());
                bufferNotEmpty.await();
            }

            int number = new Random().nextInt();
            boolean isAdded = products.offer(number);
            System.out.println("Add value " + number);
            if(isAdded){
                bufferNotFull.signalAll();
            }
        } finally {
            aLock.unlock();
        }

    }

    public void get() throws InterruptedException {
        aLock.lock();
        try{
            while (products.isEmpty()){
                System.out.println("Buffer is empty by thread " + Thread.currentThread().getName());
                bufferNotFull.await();
            }

            Integer value = products.poll();

            if(value != null){
                System.out.println("Get value " + value);
                bufferNotEmpty.signalAll();
            }

        } finally {
            aLock.unlock();
        }
    }
}

class Producer extends Thread {
    Products products;

    public Producer(Products products){
        super("PRODUCER");
        this.products = products;
    }

    @Override
    public void run() {
        try {

            for (int i = 0; i< 20; ++i) {
                products.put();
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    Products products;

    public Consumer(Products products) {
        super("CONSUMER");

        this.products = products;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i< 20; ++i) {
                products.get();
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}


public class ProducerConsumerSolutionUsingLock {
    public static void main(String[] args) {
        Products products = new Products();

        BlockingQueue<Integer> integers = new ArrayBlockingQueue<>(5);
        /*List<Producer> producers = Arrays.asList(
                new Producer(products),
                new Producer(products),
                new Producer(products)
        );

        List<Consumer> consumers = Arrays.asList(
                new Consumer(products),
                new Consumer(products),
                new Consumer(products)
        );

        producers.stream().forEach(Thread::start);
        consumers.stream().forEach(Thread::start);

        */
        Producer producer = new Producer(products);
        Consumer consumer = new Consumer(products);

        producer.start();
        consumer.start();
    }
}
