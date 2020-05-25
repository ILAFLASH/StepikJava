package com.stepik.lesson3;

import java.util.function.DoubleUnaryOperator;

public abstract class Test1 implements DoubleUnaryOperator {

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double sum = 0.0;
        for (double i = a; i < b; i = i + Math.pow(10, -6) ) {
            sum += f.applyAsDouble(i) * (Math.pow(10, -6));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(integrate(operand -> 1, 0, 10));
    }
}
