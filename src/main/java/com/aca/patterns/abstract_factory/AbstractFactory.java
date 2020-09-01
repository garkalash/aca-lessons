package com.aca.patterns.abstract_factory;

/**
 * @author: garik
 * @created" 9/1/2020, 10:32 PM
 */
public abstract class AbstractFactory {
    abstract MyShape getShape(String name);
}

class ShapeFactory extends AbstractFactory{

    @Override
    MyShape getShape(String name) {
        if(name.equalsIgnoreCase("r")){
            return new Rectangle();
        } else if(name.equalsIgnoreCase("s")){
            return new Square();
        }

        return null;
    }
}

class RoundedShapeFactory extends AbstractFactory{

    @Override
    MyShape getShape(String name) {
        if(name.equalsIgnoreCase("r")){
            return new RoundedRectangle();
        } else if(name.equalsIgnoreCase("s")){
            return new RoundedSquare();
        }

        return null;
    }
}
