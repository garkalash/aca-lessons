package com.aca.patterns.creational.builder;

import com.aca.patterns.creational.builder.component.Engine;
import com.aca.patterns.creational.builder.component.GPSNavigator;
import com.aca.patterns.creational.builder.component.Transmission;
import com.aca.patterns.creational.builder.component.Type;

/**
 * @author: garik
 * @created" 9/1/2020, 9:50 PM
 */
public class Car {
    private Type type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private GPSNavigator gpsNavigator;
    private double fuel = 0.0;

    public Car(){}

    public Car(Type type, int seats, Engine engine, Transmission transmission, GPSNavigator gpsNavigator) {
        this.type = type;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.gpsNavigator = gpsNavigator;
    }

    public Type getType() {
        return type;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public double getFuel() {
        return fuel;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setGpsNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
}
