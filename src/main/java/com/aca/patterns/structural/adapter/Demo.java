package com.aca.patterns.structural.adapter;

/**
 * @author: garik
 * @created" 9/3/2020, 8:57 PM
 */
public class Demo {
    public static void main(String[] args) {
        testObjectAdapter();
    }

    private static void testObjectAdapter(){
        SocketAdapter socketAdapter = new SocketObjectAdapterImpl();
        System.out.println(socketAdapter.get3Volt().getVolts());
        System.out.println(socketAdapter.get12Volt().getVolts());
        System.out.println(socketAdapter.get120Volt().getVolts());
    }
}
