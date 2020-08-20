package com.aca.multithreading;

/**
 * @author: garik
 * @created" 8/11/2020, 10:34 PM
 */
public class Sender implements Runnable{
    private final Data data;

    public Sender(Data data) {
        this.data = data;
    }


    @Override
    public void run() {
        String packets[] = {
                "Packet1",
                "Packet2",
                "Packet3",
                "Packet4",
                "Last"
        };

        for(String packet: packets){
            System.out.println("Sending: " + packet);
            data.send(packet);
        }
    }
}
