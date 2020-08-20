package com.aca.conversions;

public class Conversions {
    //byte - 8 bit
    //short - 16 bit
    //char - 2 byte - 16 bit
    // int  - 32 bit 64 bit
    // long  - 64 bit
    // float 32
    // double 64
    // boolean

    // binary presentation
    public static void main(String[] args) {
        byte a = 1;
        short aShort;

        //implicit excplicit

        aShort = a;
        System.out.println(aShort);

        double aDouble  = 2.5;
        int aInt = (int) aDouble;
        System.out.println(aInt);

        //Boxing/Autoboxing
        Integer aWrapInt = aInt;

        Fruit fruit = new Fruit();
        Apple apple = new Apple();

        if(fruit instanceof Apple)
            apple = (Apple) fruit;
        apple.a();

        Fruit fruit1 = new Pear();
        fruit1.a(new Pear());
    }



}


//Overriding runtime        Runtime polymorphism
//Overriding compile -> Overfrloading -> Static polymorphism


class Fruit {
    protected void a(Fruit fruit) {
        System.out.println("Fruit a");
    }

}

class Apple extends Fruit{
    public void a() {
        System.out.println("Apple a");
    }
}

class Pear extends Fruit {
    private Integer weight;

    public void printDetails(Fruit fruit) {

        System.out.println("Pear with fruit a");
    }

    public void printDetails() {

        System.out.println("Pear aa");
    }

    public void pearMethod(){}

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

class ASortPear extends Pear{
    private String color;
    public void aSortPearMethod(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
