package com.aca.multithreading;

import java.util.Date;

/**
 * @author: garik
 * @created" 8/11/2020, 10:07 PM
 */

class ARunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from Arunnable " + new Date().toString());
    }
}

class AThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from AThread " + new Date().toString());
    }
}


public class Main {
    public static void main(String[] args) {
        testPacketExchanging();
    }

    private static void testPacketExchanging(){
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));

        Thread receiver = new Thread(new Receiver(data));
        receiver.setPriority(1);
        sender.start();
        receiver.start();
    }
}
