package com.aca.oop.solid.liskov;

public class Crow implements Bird{
    private final String name;

    public Crow(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + " crow is flying");
    }

    @Override
    public void eat() {
        System.out.println(name + " crow is eating");
    }
}
