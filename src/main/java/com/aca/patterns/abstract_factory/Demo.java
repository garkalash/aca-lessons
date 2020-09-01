package com.aca.patterns.abstract_factory;

/**
 * @author: garik
 * @created" 9/1/2020, 10:40 PM
 */
public class Demo {
    public static void main(String[] args) {
        AbstractFactory rounded =FactoryProvider.getFactory(true);
        rounded.getShape("r").draw();
        rounded.getShape("s").draw();
    }
}
