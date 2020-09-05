package com.aca.patterns.creational.abstract_factory;

public interface MyShape {
    void draw();
}

class RoundedRectangle implements MyShape{

    @Override
    public void draw() {
        System.out.println("rounding rectangle drawing");
    }
}

class RoundedSquare implements MyShape{

    @Override
    public void draw() {
        System.out.println("rounding square drawing");
    }
}

class Rectangle implements MyShape{

    @Override
    public void draw() {
        System.out.println("rectangle drawing");
    }
}

class Square implements MyShape{

    @Override
    public void draw() {
        System.out.println("square drawing");
    }
}
