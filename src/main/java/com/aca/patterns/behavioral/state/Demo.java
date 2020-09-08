package com.aca.patterns.behavioral.state;

/**
 * @author: garik
 * @created" 9/8/2020, 10:37 PM
 */
public class Demo {
    public static void main(String[] args) {
        DeliveryContext context = new DeliveryContext("pckg1", null);
        context.update();
        context.update();
        context.update();
        context.update();
        context.update();
        context.update();
    }
}
