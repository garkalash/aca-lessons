package com.aca.patterns.behavioral.strategy;

public interface PaymentStrategy {
    boolean isAvailable();
    void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy{

    public boolean isAvailable(){
        return false;
    }

    @Override
    public void pay(int amount) {

    }
}

class PaypalStrategy implements PaymentStrategy{

    public boolean isAvailable(){
        return true;
    }

    @Override
    public void pay(int amount) {

    }
}
