package com.aca.patterns.creational.factory;

/**
 * @author: garik
 * @created" 9/1/2020, 10:22 PM
 */
public class Demo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("r").draw();
    }
}
