package com.aca.patterns.behavioral.strategy;

/**
 * @author: garik
 * @created" 9/8/2020, 10:50 PM
 */
public class Demo {
    public static void main(String[] args) {
        ShoppingCard shoppingCard = new ShoppingCard();
        shoppingCard.addItem(new Item("i1", 10));
        shoppingCard.addItem(new Item("i2", 12));
        shoppingCard.addItem(new Item("i3", 13));

        boolean paid = shoppingCard.pay(new CreditCardStrategy());
        if(!paid){
           boolean paidByPaypal =  shoppingCard.pay(new PaypalStrategy());
            if(!paidByPaypal){
                System.out.println("Payment unsuccessful");
                return;
            }
        }
        System.out.println("All is ok");
    }
}
