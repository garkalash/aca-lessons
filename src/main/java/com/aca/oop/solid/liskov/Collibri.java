package com.aca.oop.solid.liskov;

public class Collibri implements Bird {
    private final String name;

    public Collibri(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + " collibri is flying");
    }

    @Override
    public void eat() {
        System.out.println(name + " collibri is eating");
    }
}
