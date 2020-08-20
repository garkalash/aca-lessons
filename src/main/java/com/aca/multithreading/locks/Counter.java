package com.aca.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: garik
 * @created" 8/13/2020, 10:24 PM
 */
public class Counter {
    private volatile int count = 0;

    private final Object DUMMY = new Object();

    private ReentrantLock lock = new ReentrantLock();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public int incAndGet(){
        lock.lock();
        ++count;
        lock.unlock();
        return count;
    }


}
