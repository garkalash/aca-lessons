package com.aca.patterns.creational.prototype;

/**
 * @author: garik
 * @created" 9/1/2020, 9:28 PM
 */
public class Circle extends Shape{
    private int radius;

    public Circle(){}

    private Circle(Circle circle){
        super(circle);
        if(circle != null){
            this.radius = circle.radius;
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }
}
