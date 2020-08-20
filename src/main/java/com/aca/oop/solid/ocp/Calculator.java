package com.aca.oop.solid.ocp;

public class Calculator {
    public void calculate(CalculatorOperator operator){
        if(operator == null) {
            System.out.println("Operator can not be null.");
            return;
        }
        operator.eval();

    }
}
