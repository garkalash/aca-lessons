package com.aca.streams.refs;

import java.util.function.Consumer;

/**
 * @author: garik
 * @created" 7/28/2020, 9:27 PM
 */

class Car{
    private int id;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Mechanic{
    public void fix(Car c) {
        System.out.println(c.getId() + " is fixed");
    }
}

class CarAction {
    public void execute(Car car, Consumer<Car> consumer){ consumer.accept(car);}
}


public class ByObj {
    public static void main(String[] args) {
        Mechanic mechanic = new Mechanic();
        Car car= new Car();
        CarAction carAction = new CarAction();
        carAction.execute(car, (c) -> mechanic.fix(c));
        carAction.execute(car, mechanic::fix);
    }
}
