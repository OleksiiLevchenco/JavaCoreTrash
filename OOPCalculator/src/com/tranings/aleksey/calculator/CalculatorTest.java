package com.tranings.aleksey.calculator;

import com.tranings.aleksey.calculator.impl.RecursionCalculator;

/**
 * @author Alexey Levchhenko
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new RecursionCalculator();
        System.out.println(calculator.calculate("(-10.2)/-2+0.4"));
    }
}
