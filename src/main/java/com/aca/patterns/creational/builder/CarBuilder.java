package com.aca.patterns.creational.builder;

import com.aca.patterns.creational.builder.component.Engine;
import com.aca.patterns.creational.builder.component.Transmission;
import com.aca.patterns.creational.builder.component.Type;

/**
 * @author: garik
 * @created: 9/1/2020, 10:01 PM
 */
public class CarBuilder {
    private Car car = new Car();
    /*
    * rivate Type type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private GPSNavigator gpsNavigator;
    private double fuel = 0.0;
    *
    */

    public CarBuilder addType(Type type){
        car.setType(type);
        return this;
    }

    public CarBuilder addFuel(double fuel){
        car.setFuel(fuel);
        return this;
    }


    public CarBuilder addTransmission(Transmission transmission){
        car.setTransmission(transmission);
        return this;
    }

    public CarBuilder addEngine(Engine engine){
        car.setEngine(engine);
        return this;
    }

    public Car build(){
        return car;
    }


}
