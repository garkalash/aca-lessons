package com.aca.patterns.prototype;

/**
 * @author: garik
 * @created" 9/1/2020, 9:25 PM
 */
public abstract class Shape {
    private int x;
    private int y;
    private String color;

    public Shape(){

    }

    protected Shape(Shape shape){
        if(shape != null){
            this.x = shape.x;
            this.y = shape.y;
            this.color = shape.color;
        }
    }

    public abstract Shape clone();
}
