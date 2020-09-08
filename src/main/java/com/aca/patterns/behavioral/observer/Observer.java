package com.aca.patterns.behavioral.observer;

public interface Observer {
    void update(Object updatedData);
}

class Subscriber implements Observer {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Object updatedData) {
        if(updatedData == null) {
            System.out.println("No new message:: " + name);
        } else {
            System.out.println(name  + "has received this update " + updatedData.toString());
        }
    }
}
