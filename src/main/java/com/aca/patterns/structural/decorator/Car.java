package com.aca.patterns.structural.decorator;

public interface Car {
    void build();
}

class BasicCar implements Car{

    @Override
    public void build() {
        System.out.println("Basic Car. ");
    }
}

class CarDecorator implements Car{
    Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void build() {
        this.car.build();
    }
}

class SportCar extends CarDecorator{

    public SportCar(Car car) {
        super(car);
    }

    @Override
    public void build() {
        super.build();
        System.out.println("Adding sport car feature");
    }

    public void setCar(Car car){
        this.car = car;
    }
}

class LuxuryCar extends CarDecorator{

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void build() {
        super.build();
        System.out.println("Adding luxury car feature");
    }
}
