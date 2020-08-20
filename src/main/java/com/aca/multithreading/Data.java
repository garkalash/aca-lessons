package com.aca.multithreading;

/**
 * @author: garik
 * @created: 8/11/2020, 10:28 PM
 */
public class Data {
    private String packet;

    private boolean transfer = true;

    public synchronized void send(String packet){
        System.out.println("Thread name " + Thread.currentThread().getName());

        while (!transfer){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        transfer = false;
        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive(){
        while(transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        transfer = true;
        notifyAll();
        return packet;
    }
}
