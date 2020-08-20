package com.aca.oop.solid.ocp;

public class Multiplication implements CalculatorOperator {
    private double left;
    private double right;

    public Multiplication(double left, double right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void eval() {
        System.out.println("Multiplication is : " + (this.left * this.right));
    }
}
