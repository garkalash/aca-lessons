package com.aca.oop.solid.ocp;

public class Subtraction implements CalculatorOperator {
    private double left;
    private double right;

    public Subtraction(double left, double right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void eval() {
        System.out.println("Subtraction is : " + (this.left - this.right));
    }
}
