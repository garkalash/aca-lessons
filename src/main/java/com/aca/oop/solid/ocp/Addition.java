package com.aca.oop.solid.ocp;

public class Addition extends BinaryOperator {

    public Addition(double left, double right) {
        super(left, right);
    }

    @Override
    public void eval() {
        System.out.println("Sum is: " + (this.left + this.right));
    }
}
