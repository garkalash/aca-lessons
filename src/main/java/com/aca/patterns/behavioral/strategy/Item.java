package com.aca.patterns.behavioral.strategy;

/**
 * @author: garik
 * @created" 9/8/2020, 10:43 PM
 */
public class Item {
    private final String name;
    private final int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }


}
