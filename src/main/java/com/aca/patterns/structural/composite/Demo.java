package com.aca.patterns.structural.composite;

/**
 * @author: garik
 * @created" 9/3/2020, 9:29 PM
 */
public class Demo {
    public static void main(String[] args) {
        int i = 0;

        ShapeComposite shapeComposite = new ShapeComposite(++i);
        shapeComposite.addShape(new Shape1(++i));
        shapeComposite.addShape(new Shape1(++i));
        shapeComposite.addShape(new Shape1(++i));
        shapeComposite.addShape(new Shape2(++i));
        shapeComposite.addShape(new Shape2(++i));
        shapeComposite.addShape(new Shape2(++i));

        ShapeComposite otherShapeComposite = new ShapeComposite(++i);
        otherShapeComposite.addShape(new Shape1(++i));
        otherShapeComposite.addShape(new Shape2(++i));

        shapeComposite.addShape(otherShapeComposite);

        shapeComposite.draw();


    }
}
