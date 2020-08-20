package com.aca.multithreading;

/**
 * @author: garik
 * @created" 8/11/2020, 10:34 PM
 */
public class Receiver implements Runnable {
    private final Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for(String response = data.receive();
            !"Last".equals(response);
            response = data.receive()) {
            System.out.println("Received " + response);
        }
    }
}
