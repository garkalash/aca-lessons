package com.aca.multithreading.deadlock;

/**
 * @author: garik
 * @created" 8/13/2020, 9:29 PM
 */
public class TestDeadlock {
    public static void main(String[] args) {
        final String resource1 = "resource1";
        final String resource2 = "resource2";

        Thread t1 = new Thread(() -> {
           synchronized (resource1){
               System.out.println("Thread1 locked r1");
               synchronized (resource2) {
                   System.out.println("Thread1 locked r2");
               }
           }
        });
        t1.setDaemon(false);

        Thread t2 = new Thread(() -> {
            synchronized (resource1){
                System.out.println("Thread2 locked r2");
                synchronized (resource2) {
                    System.out.println("Thread2 locked r1");
                }
            }
        });

        t1.start();
        t2.start();

    }
}
