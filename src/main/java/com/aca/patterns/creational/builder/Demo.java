package com.aca.patterns.creational.builder;

import com.aca.patterns.creational.builder.component.Engine;
import com.aca.patterns.creational.builder.component.Transmission;

/**
 * @author: garik
 * @created" 9/1/2020, 10:06 PM
 */
public class Demo {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();

        carBuilder.addEngine(new Engine(2.0, 150000))
                .addFuel(2.0)
                .addTransmission(Transmission.AUTOMATIC)
                .build();
    }
}
