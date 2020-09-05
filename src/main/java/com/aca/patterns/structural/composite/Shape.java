package com.aca.patterns.structural.composite;

import java.util.Objects;

/**
 * @author: garik
 * @created" 9/3/2020, 9:17 PM
 */
abstract class Shape {
    private final int id;
    public Shape(int id) {
        this.id = id;
    }

    public abstract void draw();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return id == shape.id;
    }

    public int getId() {
        return id;
    }
}

class Shape1 extends Shape {

    public Shape1(int id) {
        super(id);
    }

    @Override
    public void draw() {
        System.out.println("Drawing shape 1 " + getId());
    }
}

class Shape2 extends Shape {

    public Shape2(int id) {
        super(id);
    }

    @Override
    public void draw() {
        System.out.println("Drawing shape 2");
    }
}