package com.aca.oop.solid.liskov;

public class Ostrich implements Bird{
    private final String name;

    public Ostrich(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich doesn't fly");
    }

    @Override
    public void eat() {
        System.out.println(name + " Ostrich eating.");
    }
}
