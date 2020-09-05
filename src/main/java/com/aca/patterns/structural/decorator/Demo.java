package com.aca.patterns.structural.decorator;

/**
 * @author: garik
 * @created" 9/3/2020, 9:46 PM
 */
public class Demo {
    public static void main(String[] args) {
        Car sp1 = new SportCar(new BasicCar());
        sp1.build();

        Car sp2 = new SportCar(new LuxuryCar(new BasicCar()));
        Car sp3 = new SportCar(new LuxuryCar(new SportCar(new BasicCar())));
        sp3.build();
    }
}
