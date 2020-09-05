package com.aca.patterns.creational.builder.component;

/**
 * @author: garik
 * @created" 9/1/2020, 9:54 PM
 */
public class Engine {
    private final double volume;
    private double mileage;
    private boolean started;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on(){
        this.started = true;
    }

    public void off(){
        this.started = false;
    }

    public boolean isStarted() {
        return started;
    }

    public void go(double milage){
        if(started){
            this.mileage += milage;
        } else{
            System.out.println("Please turn on your engine");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }
}
