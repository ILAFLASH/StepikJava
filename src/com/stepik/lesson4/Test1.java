package com.stepik.lesson4;

public class Test1 {
    public static double sqrt(double x) {
        if (x < 0) { throw new IllegalArgumentException("Expected non-negative number, got " + x);
        } else return Math.sqrt(x);
    }

    public static void main(String[] args) {
        System.out.println(sqrt(5));
        System.out.println(sqrt(-5));
    }
}
