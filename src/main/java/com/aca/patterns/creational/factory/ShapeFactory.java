package com.aca.patterns.creational.factory;

/**
 * @author: garik
 * @created" 9/1/2020, 10:19 PM
 */
public class ShapeFactory {

    public Shape getShape(String shapeName){
        if(shapeName.equalsIgnoreCase("r")){
            return new Rectangle();
        } else if(shapeName.equalsIgnoreCase("s")){
            return new Square();
        } else if(shapeName.equalsIgnoreCase("c")){
            return new Circle();
        }
        return null;
    }
}
