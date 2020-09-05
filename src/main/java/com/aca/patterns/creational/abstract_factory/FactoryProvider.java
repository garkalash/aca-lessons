package com.aca.patterns.creational.abstract_factory;

/**
 * @author: garik
 * @created" 9/1/2020, 10:39 PM
 */
public class FactoryProvider {
    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        } else{
            return new ShapeFactory();
        }
    }
}
