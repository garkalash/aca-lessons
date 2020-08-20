package com.aca.exam;

public class Main {
    public static void main(String[] args) {
        System.out.println(count());
    }
    public static int count() {
        try {
            System.out.println(1/0);
            return 1;
        }
        catch(Exception e) {
            return 2;
        }
        finally {System.out.println("Finally block");    }

    }
}



