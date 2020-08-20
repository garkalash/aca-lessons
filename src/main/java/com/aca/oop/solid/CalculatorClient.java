package com.aca.oop.solid;

import com.aca.oop.solid.ocp.Addition;
import com.aca.oop.solid.ocp.Calculator;
import com.aca.oop.solid.ocp.Multiplication;
import com.aca.oop.solid.ocp.Subtraction;

public class CalculatorClient {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate(new Addition(5, 6));
        calculator.calculate(new Subtraction(6, 5));
        calculator.calculate(new Multiplication(6, 5));
    }
}
