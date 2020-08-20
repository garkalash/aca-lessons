package com.aca.oop.solid.ocp;

public abstract class BinaryOperator implements CalculatorOperator {
    protected final double left;
    protected final double right;

    public BinaryOperator(double left, double right) {
        this.left = left;
        this.right = right;
    }


}
