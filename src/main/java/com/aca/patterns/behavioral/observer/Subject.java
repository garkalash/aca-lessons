package com.aca.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}


class MyTopic implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void setMessage(String message){
        if(message != null && !message.equals(this.message)){
            this.message = message;
            notifyObservers();
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(message));
    }
}
