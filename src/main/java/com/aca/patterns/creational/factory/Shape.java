package com.aca.patterns.creational.factory;

public interface Shape {
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing square");
    }
}
