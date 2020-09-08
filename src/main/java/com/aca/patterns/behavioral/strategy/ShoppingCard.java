package com.aca.patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: garik
 * @created" 9/8/2020, 10:46 PM
 */
public class ShoppingCard {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    private Integer getSumAmount(){
        return this.items.stream().mapToInt(Item::getPrice).sum();
    }

    public boolean pay(PaymentStrategy strategy){
        if (strategy.isAvailable()) {
            strategy.pay(getSumAmount());
            return true;
        }
        return false;
    }
}
