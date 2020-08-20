package com.aca.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class NegativePriceException extends RuntimeException {
    public NegativePriceException(String message) {
        super(message);
    }
}

class Fruit {
    private static final Logger logger = Logger.getGlobal();
    private Integer price = 5;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if(price < 0) {
            logger.log(Level.SEVERE, "");
            throw new NegativePriceException(String.format("The given price can't be negative %d. ", price));
        }
        this.price = price;
    }


    @Override
    public String toString() {


      return    "a = [" + price +"]";

    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }




    // x.equals(x) = false reflexive
    // a.equals(b) = true -> b.equals(a) = true symetric
    // a.equals(b) = true && b.equals(c) = true -> a.equals(c) = true
    // a.equals(b) = true consistency
    // a.equals(null) = false
    @Override
    public boolean equals(Object obj) {
        if(obj == null ) return false;

        if(this.getClass() != obj.getClass()) return false;

        Fruit thiss = (Fruit) obj;
        return this.price.equals(thiss.price);
    }
}

public class Main {
    //java.util.Logger
    private static final Logger logger = Logger.getGlobal();


    public static void mainComparations() {
        Fruit a = new Fruit();
        a.setPrice(5);

        Fruit b = new Fruit();
        b.setPrice(5);
        b.setPrice(10);

        Fruit c = new Fruit();


        System.out.println(a == b);

        String s1 = "aa";
        String s2 = new String("aa");
        String s3 = "aa";

        String s4 = "aa" + "a";

        //immutable mutable
        //String pool
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);




        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    public static void main(String[] args) {
            System.out.println(m4());
    }

    private static void m1() {
        throw new RuntimeException("m1 excpetion");
    }

    private static void m2() throws FileNotFoundException {

    }
    private static void m3() throws Throwable {

    }

    private static Integer m4() {
        try {
            logger.setLevel(Level.OFF);
            logger.log(Level.INFO, "Usual log ");
            logger.log(Level.WARNING, "Warning message ");
            logger.log(Level.FINE, "All is fine");
            logger.info("Entered into try");

            Fruit fruit = null;
            return fruit.getPrice();
        } catch (RuntimeException e){
            logger.log(Level.SEVERE, "");
            logger.severe("Occured exception");
            return 2;
        } finally {
            logger.info("finally block");
            System.out.println("m4 finally");
        }

    }



}