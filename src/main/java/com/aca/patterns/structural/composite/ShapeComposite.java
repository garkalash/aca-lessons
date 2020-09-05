package com.aca.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: garik
 * @created" 9/3/2020, 9:21 PM
 */
public class ShapeComposite extends Shape {
    private final List<Shape> shapes = new ArrayList<>();

    public ShapeComposite(int id) {
        super(id);
    }

    public void addShape(Shape shape){
        this.shapes.add(shape);
    }

    public void remove(Shape shape){
        this.shapes.remove(shape);
    }

    @Override
    public void draw() {
        System.out.println("Drawing composite " + getId());
        shapes.forEach(Shape::draw);
    }
}
